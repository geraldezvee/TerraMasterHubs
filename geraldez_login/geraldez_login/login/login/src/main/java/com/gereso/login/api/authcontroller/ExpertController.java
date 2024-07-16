package com.gereso.login.api.authcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gereso.login.api.usermodel.ExpertModel;
import com.gereso.login.userservice.ExpertService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/experts")
public class ExpertController {

    private final ExpertService expertService;

    @Autowired
    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addExpert(@RequestBody ExpertModel expert) {
        if (expert.getfullname() == null || expert.getfullname().isEmpty() ||
        expert.getspecialty() == null || expert.getspecialty().isEmpty() ||
        expert.getintroduction() == null || expert.getintroduction().isEmpty() ||
        expert.getpricerange() == null || expert.getpricerange().isEmpty() ||
        expert.getlocation() == null || expert.getlocation().isEmpty() ||
        expert.getproposalsdone() == 0) {
        return ResponseEntity.badRequest().body("All fields are required.");
        }

        ExpertModel addedExpert = expertService.addExpert(expert);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedExpert);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExpertModel>> getAllExperts() {
        List<ExpertModel> allExperts = expertService.getAllExperts();
        if (!allExperts.isEmpty()) {
            return ResponseEntity.ok(allExperts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpertModel> getExpertById(@PathVariable String id) {
        Optional<ExpertModel> expert = expertService.getExpertById(id);
        if (expert.isPresent()) {
            return ResponseEntity.ok(expert.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
