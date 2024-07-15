package com.gorest.model;

public class PostsPojo {

    private Integer id;
    private Integer userID;
    private String title;
    private String body;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
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

    public static PostsPojo getPostsPojo(int id,int userID,String title,String body){
        PostsPojo postsPojo = new PostsPojo();
        postsPojo.setId(id);
        postsPojo.setUserID(userID);
        postsPojo.setTitle(title);
        postsPojo.setBody(body);
        return postsPojo;
    }
}
