package com.gereso.login.api.authcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gereso.login.api.usermodel.SurveyorModel;
import com.gereso.login.userservice.SurveyorService;


@RestController
@RequestMapping("/surveyor")
public class SurveyorController {

    private final SurveyorService surveyorService;

    @Autowired
    public SurveyorController(SurveyorService surveyorService) {
        this.surveyorService = surveyorService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSurveyor(@RequestBody SurveyorModel surveyor) {
        if (surveyor.getfullname() == null || surveyor.getfullname().isEmpty() ||
        surveyor.getspecialty() == null || surveyor.getspecialty().isEmpty() ||
        surveyor.getintroduction() == null || surveyor.getintroduction().isEmpty() ||
        surveyor.getpricerange() == null || surveyor.getpricerange().isEmpty() ||
        surveyor.getlocation() == null || surveyor.getlocation().isEmpty() ||
        surveyor.getproposalsdone() == 0) {
        return ResponseEntity.badRequest().body("All fields are required.");
        }

        SurveyorModel addedSurveyor = surveyorService.addSurveyor(surveyor);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedSurveyor);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SurveyorModel>> getAllSurveyor() {
        List<SurveyorModel> allSurveyor = surveyorService.getAllSurveyor();
        if (!allSurveyor.isEmpty()) {
            return ResponseEntity.ok(allSurveyor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyorModel> getSurveyorById(@PathVariable String id) {
        Optional<SurveyorModel> surveyor = surveyorService.getSurveyorById(id);
        if (surveyor.isPresent()) {
            return ResponseEntity.ok(surveyor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
