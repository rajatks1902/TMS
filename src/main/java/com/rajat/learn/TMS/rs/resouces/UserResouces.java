package com.rajat.learn.TMS.rs.resouces;

//import com.rajat.learn.TMS.model.CurrentUser;
import ch.qos.logback.core.model.Model;
import com.rajat.learn.TMS.model.Task;
import com.rajat.learn.TMS.model.User;
import com.rajat.learn.TMS.rs.managers.TaskManager;
import com.rajat.learn.TMS.rs.managers.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class UserResouces {

    @Autowired
    private UserManager userManager;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        userManager.saveNewUser(user);
    }

    @PostMapping("login")
    public void login(@RequestBody User user){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (user.getUserName(),user.getPassword()));


    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Add any model attributes if needed
        return "dashboard"; // This resolves to src/main/resources/templates/dashboard.html
    }


}
