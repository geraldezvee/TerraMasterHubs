package com.gereso.login.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gereso.login.api.repos.ExpertRepository;
import com.gereso.login.api.usermodel.ExpertModel;

@Service
public class ExpertService {

    private final ExpertRepository expertRepository;

    @Autowired
    public ExpertService(ExpertRepository expertRepository) {
        this.expertRepository = expertRepository;
    }

    public ExpertModel addExpert(ExpertModel expert) {
        return expertRepository.save(expert);
    }
    
    public List<ExpertModel> getAllExperts() {
        return expertRepository.findAll();
    }

    public Optional<ExpertModel> getExpertById(String id) {
        return expertRepository.findById(id);
    }

}
