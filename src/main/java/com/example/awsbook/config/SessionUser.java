package com.example.awsbook.config;

import com.example.awsbook.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;

    public SessionUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
