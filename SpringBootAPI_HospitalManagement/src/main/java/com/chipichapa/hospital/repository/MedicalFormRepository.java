package com.chipichapa.hospital.repository;

import com.chipichapa.hospital.model.MedicalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalFormRepository extends JpaRepository<MedicalForm,Long> {
    List<MedicalForm> findMedicalFormBySicknessesId(Long sicknessId);
}
