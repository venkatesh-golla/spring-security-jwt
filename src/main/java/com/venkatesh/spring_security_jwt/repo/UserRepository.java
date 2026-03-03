package com.venkatesh.spring_security_jwt.repo;

import com.venkatesh.spring_security_jwt.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
