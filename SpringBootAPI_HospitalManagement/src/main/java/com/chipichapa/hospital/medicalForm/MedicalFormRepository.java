package com.chipichapa.hospital.medicalForm;

import com.chipichapa.hospital.staff.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
public interface MedicalFormRepository extends JpaRepository<MedicalForm,Long> {

    List<MedicalForm> findAllByTime(LocalDateTime time);
    List<MedicalForm> findAllByDoctor(Doctor doctor);
}
