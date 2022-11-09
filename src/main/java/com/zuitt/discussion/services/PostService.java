package com.zuitt.discussion.services;

import com.zuitt.discussion.models.Post;
import org.springframework.http.ResponseEntity;

public interface PostService {
//    Add a createPost method that the "PostServiceImpl" class will have
    void createPost(String stringToken, Post post);
//    Retrieve ALL posts
    Iterable<Post> getPosts();
//    delete a post
    ResponseEntity deletePost(Long id, String stringToken);
//update a post
    ResponseEntity updatePost(Long id, String stringToken, Post post);
//Get specific post
    Iterable<Post> getMyPosts(String stringToken);
}
