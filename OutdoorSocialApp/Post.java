public class Post {
    private String content;
    private String imagePath;

    // These are the post details.
    public Post(String content, String imagePath) {
        this.content = content;
        this.imagePath = imagePath;
    }

    // Post a comment.
    public String getContent() {
        return content;
    }

    // Get the image path.
    public String getImagePath() {
        return imagePath;
    }
}
