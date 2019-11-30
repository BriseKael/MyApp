package com.example.myapp.model;

import java.util.Optional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDO {
    private String username;

    private String password;

    @Override
    public String toString() {
        return "UserDO{" + "username='" + username + '\'' + ", password='"
            + Optional.ofNullable(password).map(password -> "******").orElse("null") + '\'' + '}';
    }
}
