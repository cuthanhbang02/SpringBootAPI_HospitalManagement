package com.chipichapa.hospital.repository;

import com.chipichapa.hospital.model.MedicalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalFormRepository extends JpaRepository<MedicalForm,Long> {
//
//    List<MedicalForm> findAllByTime(LocalDateTime time);
//    List<MedicalForm> findAllByDoctor(Doctor doctor);
}
