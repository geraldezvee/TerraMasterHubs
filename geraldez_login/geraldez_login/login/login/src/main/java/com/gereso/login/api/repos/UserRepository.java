package com.gereso.login.api.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gereso.login.api.usermodel.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {
    UserModel findByEmailAddressAndPassword(String emailAddress, String password);
    UserModel findByEmailAddress(String emailAddress);
}
