package com.NaserGharbieh.Authentication.models;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "post_Text",nullable = false)
    private String postText;
    @ManyToOne
    private SiteUser postBySiteUser;


    public Post(){

    }


    public Post(String postText, SiteUser siteUser) {
        this.postText = postText;
        this.postBySiteUser = siteUser;
    }

    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public SiteUser getPostBySiteUser() {
        return postBySiteUser;
    }

    public void setPostBySiteUser(SiteUser postBySiteUser) {
        this.postBySiteUser = postBySiteUser;
    }
}
