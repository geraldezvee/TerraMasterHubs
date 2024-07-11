package com.gereso.login.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gereso.login.api.repos.UserRepository;
import com.gereso.login.api.usermodel.UserModel;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel authenticateUser(String emailAddress, String password) {
        return userRepository.findByEmailAddressAndPassword(emailAddress, password);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel registerUser(UserModel newUser) {
        if (userRepository.findByEmailAddress(newUser.getEmailAddress()) != null) {
            return null;
        }

        // Save the new user
        return userRepository.save(newUser);
    }
}
