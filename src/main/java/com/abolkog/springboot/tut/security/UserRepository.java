package com.abolkog.springboot.tut.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<AppUser, Long> { // 4 to save user  in db

    AppUser findByEmail (String email);
    AppUser findByName (String username);

}


