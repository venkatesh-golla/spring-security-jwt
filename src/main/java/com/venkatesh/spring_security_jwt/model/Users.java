package com.venkatesh.spring_security_jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
}
