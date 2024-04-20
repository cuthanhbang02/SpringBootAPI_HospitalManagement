package com.chipichapa.hospital.patient.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findAllByFullName(String fullName);
    List<Patient> findAllByPhoneNumber(String phoneNumber);
}
