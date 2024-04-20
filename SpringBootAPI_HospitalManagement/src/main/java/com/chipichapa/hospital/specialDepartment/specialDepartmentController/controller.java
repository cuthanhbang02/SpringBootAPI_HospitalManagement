package com.chipichapa.hospital.specialDepartment.specialDepartmentController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.chipichapa.hospital.specialDepartment.SpecialDepartment;
import com.chipichapa.hospital.specialDepartment.specialDepartmentRepository.repository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class controller {
    @Autowired
    private repository specialDepartmentRepository;

    @GetMapping("/dnoomnse/specialDepartment/getAllSpecial_Departments")
    public List<SpecialDepartment> getAllSpecial_Departments(){
        return specialDepartmentRepository.findAll();
    }

    @PostMapping("/dnoomnse/specialDepartment/createSpecial_Department")
    public SpecialDepartment createSpecial_Department(@RequestBody SpecialDepartment special_department) {
        return specialDepartmentRepository.save(special_department);
    }

    @GetMapping("/dnoomnse/specialDepartment/getspecialDepartmentById/{id}")
    public ResponseEntity<SpecialDepartment> getspecialDepartmentById(@PathVariable Long id) {
        SpecialDepartment special_department = specialDepartmentRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));
        return ResponseEntity.ok(special_department);
    }

    @PutMapping("/dnoomnse/specialDepartment/updateSpecial_Department/{id}")
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

    @DeleteMapping("/dnoomnse/specialDepartment/deleteSpecial_Department/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSpecial_Department(@PathVariable Long id){
        SpecialDepartment special_department = specialDepartmentRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        specialDepartmentRepository.delete(special_department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
