package com.chipichapa.hospital.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<WorkShift>> getAllWork_shifts() {
        List<WorkShift> workShifts = new ArrayList<WorkShift>(workShiftRepository.findAll());
        if (workShifts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(workShifts, HttpStatus.OK);
    }

    @GetMapping("/workShifts/{id}")
    public ResponseEntity<WorkShift> getWorkShiftById(@PathVariable("id") Long id) {
        WorkShift work_shift = workShiftRepository.findById(id)
                .orElseThrow(() -> new Exception("Work Shift not exist with id :" + id));
        return ResponseEntity.ok(work_shift);
    }

    @PostMapping("/workShifts/add")
    public ResponseEntity<WorkShift> createWorkShift(@RequestBody WorkShift workShift) {
        WorkShift _workShift = workShiftRepository.save(workShift);
        return new ResponseEntity<>(_workShift, HttpStatus.CREATED);
    }

    @PutMapping("/workShifts/update/{id}")
    public ResponseEntity<WorkShift> updateWorkShift(@PathVariable("id") Long id, @RequestBody WorkShift workShiftDetails){
        WorkShift workShift = workShiftRepository.findById(id)
                .orElseThrow(() -> new Exception("Work Shift not exist with id :" + id));

        workShift.setRoom(workShiftDetails.getRoom());
        workShift.setStaff(workShiftDetails.getStaff());
        workShift.setStartTime(workShiftDetails.getStartTime());
        workShift.setEndTime(workShiftDetails.getEndTime());

        WorkShift updatedWorkshift = workShiftRepository.save(workShift);
        return ResponseEntity.ok(updatedWorkshift);
    }

    @DeleteMapping("/workShifts/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteWorkShift(@PathVariable("id") Long id){
        WorkShift workShift = workShiftRepository.findById(id)
                .orElseThrow(() -> new Exception("Work Shift not exist with id :" + id));

        workShiftRepository.delete(workShift);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
