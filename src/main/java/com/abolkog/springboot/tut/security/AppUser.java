package com.abolkog.springboot.tut.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.lang.annotation.Documented;
import java.util.Collection;
import java.util.Date;


@Entity //specifies that the class is an entity and is mapped to a database table
@Table(name = "users")

public class AppUser implements UserDetails { // 3 AppUser is our model like Todoo class we created before

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id ;

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    @JsonIgnore // to hide password while returnig data
    private String password;

    private Date created;

    public AppUser() {}

    public AppUser(@NotEmpty String email, @NotEmpty String password, @NotEmpty String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.created = new Date(); // initialization for our Date
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() { // we do not need the app to expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
