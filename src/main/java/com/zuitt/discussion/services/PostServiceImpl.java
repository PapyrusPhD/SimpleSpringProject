package com.zuitt.discussion.services;

import com.zuitt.discussion.config.JwtToken;
import com.zuitt.discussion.models.Post;
import com.zuitt.discussion.models.User;
import com.zuitt.discussion.repositories.PostRepository;
import com.zuitt.discussion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//The @Service annotation will allow us to use the CRUD methods inherited from the CrudRepository even though interfaces do not contain implementation/method bodies
@Service
public class PostServiceImpl implements PostService {

//    An object cannot be instantiated from interfaces
//    @Autowired allow us to use the interface as if it was an instance of an object and allows us to use the methods from CrudRepository
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JwtToken jwtToken;

//    Create post
    public void createPost(String stringToken, Post post) {
        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        Post newPost = new Post();
        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());
        newPost.setUser(author);

        postRepository.save(newPost);
    }


//    Get posts
    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

//    Delete post

    @Override
    public ResponseEntity deletePost(Long id, String stringToken) {
        Post postForDeleting = postRepository.findById(id).get();
        String postAuthorName = postForDeleting.getUser().getUsername();
        String authenticatedUserName = jwtToken.getUsernameFromToken(stringToken);

        if(authenticatedUserName.equals(postAuthorName)){
            postRepository.deleteById(id);
            return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not authorized to delete this post.", HttpStatus.UNAUTHORIZED);
        }

    }

//    Update a post
    public ResponseEntity updatePost(Long id, String stringToken, Post post) {
        Post postForUpdating = postRepository.findById(id).get();
        String postAuthorName = postForUpdating.getUser().getUsername();
        String authenticatedUserName = jwtToken.getUsernameFromToken(stringToken);

        if(authenticatedUserName.equals(postAuthorName)){
            postForUpdating.setTitle(post.getTitle());
            postForUpdating.setContent(post.getContent());

            postRepository.save(postForUpdating);
            return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not authorized to edit this post.", HttpStatus.UNAUTHORIZED);
        }

    }


//    get all posts of a specific user
    public Iterable<Post> getMyPosts(String stringToken) {
        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        return author.getPosts();
    }



}
