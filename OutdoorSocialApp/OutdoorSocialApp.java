import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class for the Outdoor Social Media App.
public class OutdoorSocialApp {
    private User user;  // User object to store current user's information.
    private List<Activity> activities; // List to store all activities.
    private Scanner scanner; // Scanner for user input.

    // This initializes the app.
    public OutdoorSocialApp() {
        activities = new ArrayList<>(); // Initialize the activities list.
        scanner = new Scanner(System.in); // Initialize the scanner for input.
    }

    // Method to display the welcome screen and prompt for user login.
    public void welcomeScreen() {
        System.out.println("Welcome to the Outdoor Social Media App!");
        System.out.print("Please sign in with your username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter your email: ");
        String email = scanner.nextLine();
        registerUser(username, email);
    }

    // Method to register the user with their username and email.
    public void registerUser(String username, String email) {
        user = new User(username, email);
    }

    // Method to create a new activity.
    public void createActivity(String name, String location, String date) {
        Activity activity = new Activity(name, location, date);
        activities.add(activity);
        System.out.println("Activity created: " + activity.getName());
    }

    // Method to create a new post.
    public void createPost(String content, String imagePath) {
        Post post = new Post(content, imagePath);
        user.addPost(post);
        System.out.println("Post created: " + content + " [Image: " + imagePath + "]");
    }

    // Method to subscribe to an activity.
    public void subscribeToActivity(Activity activity) {
        if (!user.isSubscribed(activity)) { // Check if the user is not already subscribed.
            user.subscribe(activity); // Subscribe the user to the activity.
            System.out.println("You are now subscribed to the activity: " + activity.getName());
        } else {
            System.out.println("You are already subscribed to this activity.");
        }
    }

    // Method to prompt the user for actions they can take.
    public void promptUserActions() {
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nWould you like to:");
            System.out.println("1. View your profile");
            System.out.println("2. Create a new post");
            System.out.println("3. View upcoming activities");
            System.out.println("4. Subscribe to an activity");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    user.displayProfile(); // Display the user's profile.
                    break;
                case 2:
                    System.out.print("Enter your post content: ");
                    String postContent = scanner.nextLine(); // Get post content from user.
                    System.out.print("Enter image path (leave empty if no image): ");
                    String imagePath = scanner.nextLine(); // Get image path from user.
                    createPost(postContent, imagePath); // Create the post.
                    break;
                case 3:
                    System.out.println("Upcoming activities:");
                    if (activities.isEmpty()) { // Checks if there are no activities.
                        System.out.println(" - No upcoming activities.");
                    } else {
                        // List all upcoming activities.
                        for (Activity activity : activities) {
                            System.out.println(" - " + activity.getName() + " on " + activity.getDate());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the activity you want to subscribe to: ");
                    String activityName = scanner.nextLine(); // Get the activity name from user.
                    Activity activityToSubscribe = findActivityByName(activityName); // Find the activity.
                    if (activityToSubscribe != null) {
                        subscribeToActivity(activityToSubscribe); // Subscribe to the activity.
                    } else {
                        System.out.println("Activity not found.");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!"); // Exit message.
                    continueRunning = false; // Exit the loop.
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Method to find an activity by its name.
    private Activity findActivityByName(String name) {
        for (Activity activity : activities) {
            if (activity.getName().equalsIgnoreCase(name)) {
                return activity;
            }
        }
        return null; // Activity not found.
    }

    // Main method to run the application.
    public static void main(String[] args) {
        OutdoorSocialApp app = new OutdoorSocialApp(); // Create an instance of the app.
        app.welcomeScreen(); // Display the welcome screen.

        // Sample registered user and activities.
        app.createActivity("R Mountain Hike", "R Mountain", "2024-10-20");
        app.createActivity("Rock Climbing Trip", "Tetons National Park", "2024-10-25");
        app.createActivity("River Rafting Trip", "Snake River", "2024-11-01");
        app.createActivity("Camping at R Mountain", "R Mountain", "2024-11-10");

        // Prompt user actions after sign-in.
        app.promptUserActions();
    }
}
