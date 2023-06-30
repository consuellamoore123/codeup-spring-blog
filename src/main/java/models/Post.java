package models;


public class Post {
    private String title;
    private String body;


    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String getTitle() {
        return title;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}