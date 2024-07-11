package com.gereso.login.api.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gereso.login.api.usermodel.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByUsernameAndPassword(String emailAddress, String password);
    UserModel findByUsername(String emailAddress);

}
