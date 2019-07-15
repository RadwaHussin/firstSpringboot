package com.abolkog.springboot.tut.security;

import com.abolkog.springboot.tut.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService implements UserDetailsService { //2

    @Autowired
    public UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){ // to encode the pass
        return new BCryptPasswordEncoder();
    } // to encrept the password

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // dumy Data
        //  return new User(" Radwa", passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);  //we send username pass and the permession of user
     // **
        AppUser user = userRepository.findByName (username);

        if (user == null){ // if user not found
            System.out.println("oooooooooooooooooo"); // in case user null
            throw new NotFoundException("user with this email not found");
        }
        System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuu"); // in case user not null
        System.out.println("user" + " "+ user);

        return user;
        // **
    }
       //work

    public void save(AppUser user){ // to save our users in Database
        user.setPassword(passwordEncoder().encode(user.getPassword()));  // we need to encrept the pass while saving user
        this.userRepository.save(user);
    }

    public  List<AppUser> findAll(){
        return userRepository.findAll();
    }
}
