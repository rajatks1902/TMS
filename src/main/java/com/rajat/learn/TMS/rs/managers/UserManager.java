package com.rajat.learn.TMS.rs.managers;

import com.rajat.learn.TMS.dao.UserDao;
import com.rajat.learn.TMS.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager {


    @Autowired
    private UserDao userDao;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void saveNewUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }
}
