package com.chipichapa.hospital.repository;

import com.chipichapa.hospital.model.Sickness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicknessRepository extends JpaRepository<Sickness,Long> {

    List<Sickness> findAllBySickName(String name);

}
