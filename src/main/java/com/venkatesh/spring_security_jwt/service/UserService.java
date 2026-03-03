package com.venkatesh.spring_security_jwt.service;

import com.venkatesh.spring_security_jwt.model.Users;
import com.venkatesh.spring_security_jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(
            12);

    public Users register(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String verify(Users users) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(users.getUsername(),
                        users.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(users.getUsername());
        }
        return "Login Failed";
    }
}
