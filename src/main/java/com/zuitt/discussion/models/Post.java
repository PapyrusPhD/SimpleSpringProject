package com.zuitt.discussion.models;

import javax.persistence.*;

//Mark this Java object as a representation of an entity/record from the database table "posts"
@Entity
//Designate the table name related to the model
@Table(name="posts")
public class Post {

    // Properties
//    Indicates that this property represents the primary key of the table
    @Id
//    Values for this property will be auto-incremented
    @GeneratedValue
    private Long id;

//    Class properties that represent table columns in a relational database
    @Column
    private String title;
    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructors
    public Post() {
    }
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
