package com.chipichapa.hospital.staff.controller;


import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.chipichapa.hospital.staff.repository.DoctorRepository;
import com.chipichapa.hospital.staff.model.Doctor;
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


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // get all employees
    @GetMapping("/doctor/")
    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/doctor/add")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // get employee by id rest api
    @GetMapping("/doctor/:id")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new Exception("Doctor not exist with id :" + id));
        return ResponseEntity.ok(doctor);
    }

    // update employee rest api

    @PostMapping("/doctor/update/:id")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new Exception("Doctor not exist with id :" + id));

        doctor.setName(doctorDetails.getName());

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    // delete employee rest api
    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNurse(@PathVariable Long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new Exception("doctor not exist with id :" + id));

        doctorRepository.delete(doctor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
