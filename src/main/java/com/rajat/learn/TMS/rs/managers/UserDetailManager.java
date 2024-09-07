package com.rajat.learn.TMS.rs.managers;


import com.rajat.learn.TMS.dao.UserDao;
import com.rajat.learn.TMS.model.User;
import com.rajat.learn.TMS.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;



@Service
public class UserDetailManager  implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("No User");
        }
        return new UserPrincipal(user);
    }
}
