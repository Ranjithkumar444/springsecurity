package com.springsecuritydemo.securitydemo.Controller;


import com.springsecuritydemo.securitydemo.Model.Users;
import com.springsecuritydemo.securitydemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user) {
        try {
            Users registeredUser = service.register(user);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());  // Return the error message
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return service.verify(user);
    }
}

