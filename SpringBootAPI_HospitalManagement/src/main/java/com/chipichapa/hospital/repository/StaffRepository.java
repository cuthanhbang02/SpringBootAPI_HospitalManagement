package com.chipichapa.hospital.repository;

import com.chipichapa.hospital.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findStaffByWorkShiftsId(Long workShiftId);
}
