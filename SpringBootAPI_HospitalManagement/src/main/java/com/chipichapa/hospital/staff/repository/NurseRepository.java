package com.chipichapa.hospital.staff.repository;

import com.chipichapa.hospital.staff.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {

}