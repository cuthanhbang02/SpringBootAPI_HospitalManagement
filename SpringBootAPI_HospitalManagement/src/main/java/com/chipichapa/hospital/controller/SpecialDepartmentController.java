package com.chipichapa.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chipichapa.hospital.standardization.Standardization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chipichapa.hospital.exception.Exception;
import com.chipichapa.hospital.model.SpecialDepartment;
import com.chipichapa.hospital.repository.SpecialDepartmentRepository;

@RestController
@RequestMapping("/api/v1")

public class SpecialDepartmentController {
    @Autowired
    private SpecialDepartmentRepository specialDepartmentRepository;

    @GetMapping("/specialDepartments")
    public List<SpecialDepartment> getAllSpecial_Departments(){
        return specialDepartmentRepository.findAll();
    }

    @PostMapping("/specialDepartments/add")
    public SpecialDepartment createSpecial_Department(@RequestBody SpecialDepartment special_department) {
        Standardization standardization = new Standardization();
        String name = special_department.getName();
        String specialist =special_department.getSpecialist();
        name =standardization.StandardSpace(name);
        specialist = standardization.StandardSpace(specialist);
        special_department.setName(name);
        special_department.setSpecialist(specialist);
        return specialDepartmentRepository.save(special_department);
    }

    @GetMapping("/specialDepartments/{id}")
    public ResponseEntity<SpecialDepartment> getspecialDepartmentById(@PathVariable Long id) {
        SpecialDepartment special_department = specialDepartmentRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));
        return ResponseEntity.ok(special_department);
    }

    @PutMapping("/specialDepartments/update/{id}")
    public ResponseEntity<SpecialDepartment> updateSpecial_Department(@PathVariable Long id, @RequestBody SpecialDepartment special_departmentDetails){
        SpecialDepartment special_department = specialDepartmentRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        special_department.setId(special_departmentDetails.getId());
        special_department.setName(special_departmentDetails.getName());
        special_department.setSpecialist(special_departmentDetails.getSpecialist());
        special_department.setDoctors(special_departmentDetails.getDoctors());

        SpecialDepartment updatedSpecialDepartment = specialDepartmentRepository.save(special_department);
        return ResponseEntity.ok(updatedSpecialDepartment);
    }

    @DeleteMapping("/specialDepartments/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSpecial_Department(@PathVariable Long id){
        SpecialDepartment special_department = specialDepartmentRepository.findById(id)
                .orElseThrow(() -> new Exception("Department not exist with id :" + id));

        specialDepartmentRepository.delete(special_department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
