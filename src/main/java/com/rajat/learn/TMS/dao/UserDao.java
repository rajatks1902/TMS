package com.rajat.learn.TMS.dao;

import com.rajat.learn.TMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUserName(String userName);  // Finds a user by the 'userName' field
}
