package com.zuitt.discussion.controllers;


import com.zuitt.discussion.models.Post;
import com.zuitt.discussion.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Serializes all responses of the PostController as HTTP responses
//Serialization - an object in java that can be represented as a sequence of bytes that includes the object's data as well as information about the object's type and types of data stored in the object
@RestController
//CORS cross-origin resource sharing
//Enable all cross origin requests via @CrossOrigin
@CrossOrigin
public class PostController {

    @Autowired
    PostService postService;


//    Create post
//    ResponseEntity represents the whole HTTP response: status code, headers and body
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity<Object> createPost(@RequestHeader(value = "Authorization") String stringToken, @RequestBody Post post) {
        postService.createPost(stringToken, post);
        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
    }

//    Get posts
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<Object> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

//    delete post
    @RequestMapping(value = "/posts/{postid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePost(@PathVariable Long postid, @RequestHeader(value = "Authorization") String stringToken){
        return postService.deletePost(postid, stringToken);
    }

//    Update post
    @RequestMapping(value = "/posts/{postid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePost(@PathVariable Long postid, @RequestHeader(value = "Authorization") String stringToken, @RequestBody Post post) {
        return postService.updatePost(postid, stringToken, post);
    }

//    Get user's posts
    @RequestMapping(value = "/myPosts", method = RequestMethod.GET)
    public ResponseEntity<Object> getPosts(@RequestHeader(value = "Authorization") String stringToken) {
        return new ResponseEntity<>(postService.getMyPosts(stringToken), HttpStatus.OK);
    }

}
