package com.gereso.login.api.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gereso.login.api.usermodel.ExpertModel;

public interface ExpertRepository extends MongoRepository<ExpertModel, Integer>{

}
