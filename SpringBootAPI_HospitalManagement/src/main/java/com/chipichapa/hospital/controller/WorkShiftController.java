package com.chipichapa.hospital.controller;

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
import com.chipichapa.hospital.model.WorkShift;
import com.chipichapa.hospital.repository.WorkShiftRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class WorkShiftController {
    @Autowired
    private WorkShiftRepository workShiftRepository;

    @GetMapping("/workShifts")
    public List<WorkShift> getAllWork_shifts(){
        return workShiftRepository.findAll();
    }

    @PostMapping("/workShifts/add")
    public WorkShift createWork_shift(@RequestBody WorkShift work_shift) {
        return workShiftRepository.save(work_shift);
    }

    @GetMapping("/workShifts/{id}")
    public ResponseEntity<WorkShift> getWorkshiftById(@PathVariable Long id) {
        WorkShift work_shift = workShiftRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));
        return ResponseEntity.ok(work_shift);
    }

    @PutMapping("/workShifts/update/{id}")
    public ResponseEntity<WorkShift> updateWork_shift(@PathVariable Long id, @RequestBody WorkShift work_shiftDetails){
        WorkShift work_shift = workShiftRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        work_shift.setId(work_shiftDetails.getId());
        work_shift.setRoom(work_shiftDetails.getRoom());
        work_shift.setStaff(work_shiftDetails.getStaff());
        work_shift.setStartTime(work_shiftDetails.getStartTime());
        work_shift.setEndTime(work_shiftDetails.getEndTime());

        WorkShift updatedWorkshift = workShiftRepository.save(work_shift);
        return ResponseEntity.ok(updatedWorkshift);
    }

    @DeleteMapping("/workShifts/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteWork_shift(@PathVariable Long id){
        WorkShift work_shift = workShiftRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        workShiftRepository.delete(work_shift);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
