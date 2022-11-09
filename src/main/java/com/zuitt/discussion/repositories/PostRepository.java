package com.zuitt.discussion.repositories;

import com.zuitt.discussion.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Post is the data used in the methods
//Object is the data type of the data returned from database(Post)

//Repositories reduce the amount of code required to implement data access layers.
//to provide abstraction by hiding away codes to interact with the database.
//Allowing for basic CRUD functionalities without the hassle of manually creating database access logic

//An interface marked as @Repository for database manipulation
//By extending CrudRepository, PostRepository will inherit its pre-defined methods for creating, retrieving, updating and deleting records
@Repository
public interface PostRepository extends CrudRepository<Post, Object> {
}
