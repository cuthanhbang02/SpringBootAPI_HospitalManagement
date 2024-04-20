package com.chipichapa.hospital.sickness;

import com.chipichapa.hospital.medicalForm.MedicalForm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Set;
public interface SicknessRepository extends JpaRepository<Sickness,Long> {

    List<Sickness> findAllBySickName(String name);

}
