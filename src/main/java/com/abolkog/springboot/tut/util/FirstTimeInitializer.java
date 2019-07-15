package com.abolkog.springboot.tut.util;

import com.abolkog.springboot.tut.security.AppUser;
import com.abolkog.springboot.tut.security.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class); // used as system.out.println

    @Autowired
    private UserService userService ;

    @Override
    public void run(String... args) throws Exception { // 5 security when we run this is the first method run

//        System.out.println("hiiii radwaaaaaaaaaaaaaaaaa3");


        //check if we have users
        //if no user so create some users

        if(userService.findAll().isEmpty()){
            logger.info("no user account was found. Creating some users");

            AppUser user = new AppUser("Radwa@elmenus.com", "password","radwa"); // this is the user we will created in database
            userService.save(user);

        }
    }
}
