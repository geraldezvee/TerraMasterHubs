package com.gereso.login.api.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gereso.login.api.usermodel.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByUsernameAndPassword(String username, String password);
    UserModel findByUsername(String username);

}
