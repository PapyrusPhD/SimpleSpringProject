package com.zuitt.discussion;

import com.zuitt.discussion.models.Post;
import com.zuitt.discussion.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

//@RestController annotation tells Spring Boot that this application that will function as an endpoint that will be used in handling web request.
//@RequestMapping annotation will require all routes/endpoint within the class to use "/greeting" as part of its route.
@SpringBootApplication
//@RestController
//@RequestMapping("/greeting")
public class DiscussionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscussionApplication.class, args);
	}

	// Retrieving all posts
	// http://localhost:8080/posts
//	@GetMapping("/posts")
//	public String getPosts() {
//		return "All posts retrieved";
//	}

	// Create a post
	// http://localhost:8080/posts
//	@PostMapping("/posts")
//	public String createPost() {
//		return "New post created";
//	}

	// Retrieving a single post
//	@GetMapping("/posts/{postId}")
//	public String getPost(@PathVariable int postId){
//		return "Viewing details of post " + postId;
//	}

	// Deleting a post
//	@DeleteMapping("/posts/{postId}")
//	public String deletePost(@PathVariable int postId) {
//		return "The post " + postId + " has been delete";
//	}

	// Updating a post
//	@PutMapping("/posts/{postId}")
//	public Post updatePost(@PathVariable int postId, @RequestBody Post post) {
//		return post;
//	}

	// Retrieving posts for a particular user
	// http://localhost:8000/posts/myPosts
//	@GetMapping("/posts/myPosts")
//	public String getMyPosts(@RequestHeader(value = "Authorization") String user) {
//		return "Posts for " + user + " have been retrieved";
//	}

	// Retrieving all users
	// http://localhost:8080/users
//	@GetMapping("/users")
//	public String getUsers() {
//		return "All users retrieved";
//	}
	// Creating a new user
	// http://localhost:8080/users
	// @RequestMapping(value = "/users", method = RequestMethod.POST)
//	@PostMapping("/users")
//	public String createUser() {
//		return "New user created";
//	}

	// Retrieving a single user
	// http://localhost:8080/users/1234
	// @RequestMapping(value = "/users/{userid}", method = RequestMethod.GET)
//	@GetMapping("/users/{userId}")
//	public String getUser(@PathVariable Long userId) {
//		return "Viewing details of user " + userId;
//	}

	// Deleting a user
	// http://localhost:8080/users/1234
	// @RequestMapping(value = "/users/{userid}", method = RequestMethod.DELETE)
//	@DeleteMapping("/users/{userId}")
//	public String deleteUser(@PathVariable Long userId, @RequestHeader(value="Authorization") String user) {
//
//		if (user.isEmpty()) {
//			return "Unauthorized Access";
//		} else {
//			return user;
//		}
//
//	}

	// Updating a user
	// http://localhost:8080/users/1234
	// @RequestMapping(value = "/users/{userid}", method = RequestMethod.PUT)
//	@PutMapping("/users/{userId}")
//	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
//		return user;
//	}

}
