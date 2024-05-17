package com.chipichapa.hospital.controller;

import com.chipichapa.hospital.model.Staff;
import com.chipichapa.hospital.model.WorkShift;
import com.chipichapa.hospital.repository.StaffRepository;
import com.chipichapa.hospital.repository.WorkShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chipichapa.hospital.exception.Exception;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private WorkShiftRepository workShiftRepository;

    @GetMapping("/staffs")
    public ResponseEntity<List<Staff>> getAllStaffs() {
        List<Staff> staffs = new ArrayList<Staff>(staffRepository.findAll());
        if (staffs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    @GetMapping("/workShifts/{workShiftId}/staffs")
    public ResponseEntity<List<Staff>> getAllStaffsByWorkShiftId(@PathVariable(value = "workShiftId") Long workShiftId) {
        if (workShiftRepository.findById(workShiftId).isEmpty()) {
            throw new Exception("Work Shift not exist with id :" + workShiftId);
        }
        List<Staff> staffs = staffRepository.findStaffByWorkShiftsId(workShiftId);
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    @GetMapping("/staffs/{id}")
    public ResponseEntity<Staff> getStaffsById(@PathVariable(value = "id") Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new Exception("Staff not exist with id :" + id));

        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @GetMapping("/staffs/{staffId}/workShifts")
    public ResponseEntity<List<WorkShift>> getAllWorkShiftsByStaffId(@PathVariable(value = "staffId") Long staffId) {
        if (staffRepository.findById(staffId).isEmpty()) {
            throw new Exception("Staff not exist with id :" + staffId);
        }

        List<WorkShift> workShifts = workShiftRepository.findWorkShiftByStaffsId(staffId);
        return new ResponseEntity<>(workShifts, HttpStatus.OK);
    }

    @PostMapping("/staffs/{staffId}/workShifts")
    public ResponseEntity<WorkShift> addWorkShift(@PathVariable(value = "staffId") Long staffId, @RequestBody WorkShift workShiftRequest) {
        WorkShift workShift = staffRepository.findById(staffId).map(staff -> {
            long workShiftId = workShiftRequest.getId();

            if (workShiftId != 0L) {
                WorkShift _workShifts = workShiftRepository.findById(workShiftId)
                        .orElseThrow(() -> new Exception("Work Shift not exist with id :" + workShiftId));
                staff.addWorkShift(_workShifts);
                staffRepository.save(staff);
                return _workShifts;
            }

            // add and create new Tag
            staff.addWorkShift(workShiftRequest);
            return workShiftRepository.save(workShiftRequest);
        }).orElseThrow(() -> new Exception("Staff not exist with id :" + staffId));

        return new ResponseEntity<>(workShift, HttpStatus.CREATED);
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") long id, @RequestBody Staff staffRequest) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new Exception("Staff not exist with id :" + id));

        staff.setName(staffRequest.getName());
        staff.setDob(staffRequest.getDob());
        staff.setGender(staffRequest.getGender());
        staff.setStartDay(staffRequest.getStartDay());
        staff.setWorkShift(staffRequest.getWorkShift());

        return new ResponseEntity<>(staffRepository.save(staff), HttpStatus.OK);
    }

    @DeleteMapping("/workShìfts/{workShiftId}/staffs/{staffId}")
    public ResponseEntity<HttpStatus> deleteStaffFromWorkShift(@PathVariable(value = "workShiftId") Long workShiftId, @PathVariable(value = "staffId") Long staffId) {
        WorkShift workShift = workShiftRepository.findById(workShiftId)
                .orElseThrow(() -> new Exception("Work Shift not exist with id :" + workShiftId));

        workShift.removeStaff(staffId);
        workShiftRepository.save(workShift);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
