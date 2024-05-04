package com.chipichapa.hospital.sickness.repository;

import com.chipichapa.hospital.sickness.model.Sickness;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SicknessRepository extends JpaRepository<Sickness,Long> {

    List<Sickness> findAllBySickName(String name);

}
