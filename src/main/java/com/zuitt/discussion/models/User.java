package com.zuitt.discussion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    // Properties
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;
    @Column
    private String password;

//    Set class - is a collection that contains no duplicate elements.
//    // Annotating the posts property with the @OneToMany annotation, establishes the relationship of the property to the "user" model
    @OneToMany(mappedBy = "user") //model name "user"
//    Prevent infinite recursion with bidirectional relationships
    @JsonIgnore
    private Set<Post> posts;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

//    add a getter for the user id
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts){
        this.posts = posts;
    }


}
