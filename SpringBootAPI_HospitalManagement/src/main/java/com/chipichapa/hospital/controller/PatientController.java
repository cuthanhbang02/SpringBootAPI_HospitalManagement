package com.chipichapa.hospital.controller;

import com.chipichapa.hospital.model.Patient;
import com.chipichapa.hospital.repository.PatientRepository;
import com.chipichapa.hospital.exception.Exception;
import com.chipichapa.hospital.standardization.Standardization;

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

public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    //get request method
    @GetMapping("/patients")
    public List<Patient> findAllPatients()
    {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> findPatientByID(@PathVariable(name ="id")Long id)
    {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new Exception("Patient with id" + id + "not exist"));
        return ResponseEntity.ok(patient);
    }
    /*@GetMapping("/patients/:fullname")
    public List<Patient> findPatientByFullName(@PathVariable(name="fullName") String fullName)
    {
        Standardization standardization = new Standardization();
        fullName = standardization.StandardName(fullName);
        List<Patient> patients = patientRepository.findAllByFullName(fullName);
        return patients;
    }*/
    /*@GetMapping("/patients/:phoneNumber")
    public List<Patient> findPatientByPhoneNumber(@PathVariable(name="phoneNumber") String phoneNumber)
    {
        Standardization standardization = new Standardization();
        phoneNumber = standardization.StandardSpace(phoneNumber);
        List<Patient> patients = patientRepository.findAllByPhoneNumber(phoneNumber);
        return patients;
    }*/

    //post request method
    @PostMapping("/patients/add")
    public Patient postPatients(@RequestBody Patient patient)
    {
        Standardization standardization = new Standardization();
        patient.setFullName(standardization.StandardName(patient.getFullName()));
        patient.setPhoneNumber(standardization.StandardSpace(patient.getPhoneNumber()));
        return patientRepository.save(patient);
    }

    /*@PostMapping("/patients/")
    public List<Patient> postListPatients(@RequestBody List<Patient> patients)
    {
        Standardization standardization = new Standardization();
        int num = patients.size();
        for(int i = 0; i<num; i++)
        {
            patients.get(i).setFullName(standardization.StandardName(patients.get(i).getFullName()));
            patients.get(i).setFullName(standardization.StandardSpace(patients.get(i).getPhoneNumber()));
        }
        return patientRepository.saveAll(patients);

    }*/

    //Put request method
    @PutMapping("/patients/update/{id}")
    public ResponseEntity<Patient> putThroughID(@PathVariable(name ="id") Long id, @RequestBody Patient detailPatient)
    {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new Exception("Patient with id" + id + "not exist"));
        Standardization standardization = new Standardization();
        patient.setFullName(standardization.StandardName(detailPatient.getFullName()));
        patient.setPhoneNumber(standardization.StandardSpace(detailPatient.getPhoneNumber()));
        patient.setAddress(detailPatient.getAddress());
        patient.setGender(detailPatient.getGender());
        patient.setDateOfBirth(detailPatient.getDateOfBirth());
        patient.setMedicalForms(detailPatient.getMedicalForms());
        return ResponseEntity.ok(patient);
    }

    //Delete request method
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteThroughID(@PathVariable (name ="íd") Long id)
    {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new Exception("Patient with id" + id + "not exist"));
        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /*@DeleteMapping("/patient/")
    public ResponseEntity<Map<String,Boolean>> deleteAllPatient()
    {
        List<Patient> patients = patientRepository.findAll();
        patientRepository.deleteAll(patients);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted all", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }*/



}
