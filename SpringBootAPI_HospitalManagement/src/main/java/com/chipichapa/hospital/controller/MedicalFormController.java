package com.chipichapa.hospital.controller;

import com.chipichapa.hospital.exception.Exception;
import com.chipichapa.hospital.model.MedicalForm;

import com.chipichapa.hospital.repository.MedicalFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class MedicalFormController {

    @Autowired
    private MedicalFormRepository medicalFormRepository;
    //Get request method
    @GetMapping("/medicalForms")
    public List<MedicalForm> getAllMedicalForms()
    {
        return medicalFormRepository.findAll();
    }

    @GetMapping("/medicalForms/{id}")
    public ResponseEntity<MedicalForm> getMedicalFormByID(@PathVariable (name ="id") Long id)
    {
        MedicalForm medicalForm = medicalFormRepository.findById(id)
                .orElseThrow(()-> new Exception("Medical Form with id" + id + "not exist"));
        return ResponseEntity.ok(medicalForm);
    }

    //post request method
    @PostMapping("/medicalForms/add")
    public MedicalForm postMedicalForm(@RequestBody MedicalForm medicalForm)
    {
        return medicalFormRepository.save(medicalForm);
    }

    //put request method
    @PutMapping("/medicalForms/update/{id}")
    public ResponseEntity<MedicalForm> putMedicalFormThroughID(@PathVariable (name = "id") Long id,@RequestBody MedicalForm detailMedicalForm)
    {
        MedicalForm medicalForm = medicalFormRepository.findById(id)
                .orElseThrow(()-> new Exception("Medical Form with id" + id + "not exist"));
        medicalForm.setStatus(detailMedicalForm.getStatus());
        medicalForm.setDoctor(detailMedicalForm.getDoctor());
        medicalForm.setTime(detailMedicalForm.getTime());
        medicalForm.setSicknesses(detailMedicalForm.getSicknesses());
        return ResponseEntity.ok(medicalForm);
    }

    //delete request method
    @DeleteMapping("/medicalForms/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteMedicalFormThroughID(@PathVariable (name = "id") Long id)
    {
        MedicalForm medicalForm = medicalFormRepository.findById(id)
                .orElseThrow(()-> new Exception("Medical Form with id" + id + "not exist"));
        medicalFormRepository.delete(medicalForm);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
