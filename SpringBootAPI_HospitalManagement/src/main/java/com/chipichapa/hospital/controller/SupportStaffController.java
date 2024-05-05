package com.chipichapa.hospital.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.chipichapa.hospital.repository.SupportStaffRepository;
import com.chipichapa.hospital.model.SupportStaff;
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
public class SupportStaffController {

    @Autowired
    private SupportStaffRepository supportStaffRepository;

    // get all employees
    @GetMapping("/supportStaffs")
    public List<SupportStaff> getAllSupportStaff(){
        return supportStaffRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/supportStaffs/add")
    public SupportStaff createSupportStaff(@RequestBody SupportStaff supportStaff) {
        return supportStaffRepository.save(supportStaff);
    }

    // get employee by id rest api
    @GetMapping("/supportStaffs/{id}")
    public ResponseEntity<SupportStaff> getSupportStaffById(@PathVariable Long id) {
        SupportStaff supportStaff = supportStaffRepository.findById(id)
                .orElseThrow(() -> new Exception("SupportStaff not exist with id :" + id));
        return ResponseEntity.ok(supportStaff);
    }

    // update employee rest api

    @PostMapping("/supportStaffs/{id}")
    public ResponseEntity<SupportStaff> updateSupportStaff(@PathVariable Long id, @RequestBody SupportStaff supportStaffDetails){
        SupportStaff supportStaff = supportStaffRepository.findById(id)
                .orElseThrow(() -> new Exception("SupportStaff not exist with id :" + id));

        supportStaff.setName(supportStaffDetails.getName());

        SupportStaff updatedSupportStaff = supportStaffRepository.save(supportStaff);
        return ResponseEntity.ok(updatedSupportStaff);
    }

    // delete employee rest api
    @DeleteMapping("/supportStaffs/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSupportStaff(@PathVariable Long id){
        SupportStaff supportStaff = supportStaffRepository.findById(id)
                .orElseThrow(() -> new Exception("SupportStaff not exist with id :" + id));

        supportStaffRepository.delete(supportStaff);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}