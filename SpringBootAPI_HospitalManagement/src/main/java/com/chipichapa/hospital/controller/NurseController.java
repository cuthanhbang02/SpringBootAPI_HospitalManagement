package com.chipichapa.hospital.controller;


import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.chipichapa.hospital.repository.NurseRepository;
import com.chipichapa.hospital.model.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chipichapa.hospital.exception.Exception;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class NurseController {

    @Autowired
    private NurseRepository nurseRepository;

    // get all employees
    @GetMapping("/nurses")
    public List<Nurse> getAllNurse(){
        return nurseRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/nurses/add")
    public Nurse createNurse(@RequestBody Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    // get employee by id rest api
    @GetMapping("/nurses/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable Long id) {
        Nurse nurse = nurseRepository.findById(id)
                .orElseThrow(() -> new Exception("Nurse not exist with id :" + id));
        return ResponseEntity.ok(nurse);
    }

    // update employee rest api

    @PostMapping("/nurses/update/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @RequestBody Nurse nurseDetails){
        Nurse nurse = nurseRepository.findById(id)
                .orElseThrow(() -> new Exception("Nurse not exist with id :" + id));

        nurse.setName(nurseDetails.getName());

        Nurse updatedNurse = nurseRepository.save(nurse);
        return ResponseEntity.ok(updatedNurse);
    }

    // delete employee rest api
    @DeleteMapping("/nurses/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNurse(@PathVariable Long id){
        Nurse nurse = nurseRepository.findById(id)
                .orElseThrow(() -> new Exception("nurse not exist with id :" + id));

        nurseRepository.delete(nurse);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}