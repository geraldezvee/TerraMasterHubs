package com.gereso.login.api.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gereso.login.api.usermodel.ExpertModel;

@Repository
public interface ExpertRepository extends MongoRepository<ExpertModel, String> {
}
