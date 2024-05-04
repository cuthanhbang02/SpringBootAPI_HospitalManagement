package com.chipichapa.hospital.staff.repository;

import com.chipichapa.hospital.staff.model.SupportStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportStaffRepository extends JpaRepository<SupportStaff, Long> {

}