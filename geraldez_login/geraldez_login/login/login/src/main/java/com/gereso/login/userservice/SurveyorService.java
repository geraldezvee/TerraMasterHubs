package com.gereso.login.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gereso.login.api.repos.SurveyorRepository;
import com.gereso.login.api.usermodel.SurveyorModel;

@Service
public class SurveyorService {

     private final SurveyorRepository surveyorRespository;

    @Autowired
    public SurveyorService(SurveyorRepository surveyorRespository) {
        this.surveyorRespository = surveyorRespository;
    }

    public SurveyorModel addSurveyor(SurveyorModel surveyor) {
        return surveyorRespository.save(surveyor);
    }
    
    public List<SurveyorModel> getAllSurveyor() {
        return surveyorRespository.findAll();
    }

    public Optional<SurveyorModel> getSurveyorById(String id) {
        return surveyorRespository.findById(id);
    }

}
