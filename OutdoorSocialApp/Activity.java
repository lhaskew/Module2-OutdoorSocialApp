public class Activity {
    private String name;
    private String location;
    private String date;

    public Activity(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    // Get the name of the activity.
    public String getName() {
        return name;
    }

    // Get the location of the activity.
    public String getLocation() {
        return location;
    }

    // Get the date of the activity.
    public String getDate() {
        return date;
    }
}
