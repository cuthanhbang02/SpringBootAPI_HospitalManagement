package com.chipichapa.hospital.repository;

import com.chipichapa.hospital.model.SupportStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportStaffRepository extends JpaRepository<SupportStaff, Long> {

}