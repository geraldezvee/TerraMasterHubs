package com.gereso.login.api.authcontroller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gereso.login.api.usermodel.UserModel;
import com.gereso.login.userservice.UserService;

import springfox.documentation.annotations.ApiIgnore;


@RestController
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserModel newUser) {
        
        if (newUser.getUserName() == null || newUser.getUserName().isEmpty()
                || newUser.getPassword() == null || newUser.getPassword().isEmpty()
                || newUser.getFirstName() == null || newUser.getFirstName().isEmpty()
                || newUser.getLastName() == null || newUser.getLastName().isEmpty()
                || newUser.getEmailAddress() == null || newUser.getEmailAddress().isEmpty()) {
            return ResponseEntity.badRequest().body("All fields are required");
        }

        // Perform registration
        UserModel registeredUser = userService.registerUser(newUser);

        if (registeredUser != null) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.badRequest().body("Username (email) already exists");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body("Username and password are required");
        }

        UserModel authenticatedUser = userService.authenticateUser(username, password);

        if (authenticatedUser != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }

    }

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> allUsers = userService.getAllUsers();
        if (!allUsers.isEmpty()) {
            return ResponseEntity.ok(allUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}