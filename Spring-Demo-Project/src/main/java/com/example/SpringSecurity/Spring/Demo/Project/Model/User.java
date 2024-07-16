package com.example.SpringSecurity.Spring.Demo.Project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
public class User implements UserDetails {
    private final static String AUTHORITIES_DELIMITER = "::";
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;


    private String username;

    private  String password;

    private  String authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String [] auth = this.authorities.split(AUTHORITIES_DELIMITER);
        return (Collection<? extends GrantedAuthority>) Arrays.stream(auth)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()); 
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


}
