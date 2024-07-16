package com.example.SpringSecurity.Spring.Demo.Project.Repository;

import com.example.SpringSecurity.Spring.Demo.Project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepo extends JpaRepository<User, Integer> {

    UserDetails findByUsername(String username);
}
