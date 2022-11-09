package com.zuitt.discussion.repositories;

import com.zuitt.discussion.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Object> {

//    custom method to find a user using a username
    User findByUsername(String username);
}
