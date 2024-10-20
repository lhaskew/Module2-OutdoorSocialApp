import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private List<Post> posts; // List of posts created by the user.
    private List<Activity> subscribedActivities; // List of subscribed activities.

    // This gets all the user details.
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.posts = new ArrayList<>();
        this.subscribedActivities = new ArrayList<>();
    }

    // Method to add a post to the user's profile.
    public void addPost(Post post) {
        posts.add(post); // Add post to the list.
    }

    // Method to subscribe to an activity.
    public void subscribe(Activity activity) {
        subscribedActivities.add(activity);
    }

    // Method to check if the user is subscribed to an activity.
    public boolean isSubscribed(Activity activity) {
        return subscribedActivities.contains(activity); // Return true if subscribed.
    }

    // Method to display the user's profile information.
    public void displayProfile() {
        System.out.println("User Profile:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Posts:");
        for (Post post : posts) {
            System.out.println(" - " + post.getContent() + " [Image: " + post.getImagePath() + "]"); // Display each post.
        }
        System.out.println("Subscribed Activities:");
        if (subscribedActivities.isEmpty()) {
            System.out.println(" - No subscribed activities."); // Message if no activities are subscribed.
        } else {
            for (Activity activity : subscribedActivities) {
                System.out.println(" - " + activity.getName() + " on " + activity.getDate()); // List subscribed activities.
            }
        }
    }
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
