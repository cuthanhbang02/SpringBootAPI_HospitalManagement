package com.chipichapa.hospital.medicalForm.repository;

import com.chipichapa.hospital.medicalForm.model.MedicalForm;
import com.chipichapa.hospital.staff.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
public interface MedicalFormRepository extends JpaRepository<MedicalForm,Long> {
//
//    List<MedicalForm> findAllByTime(LocalDateTime time);
//    List<MedicalForm> findAllByDoctor(Doctor doctor);
}
