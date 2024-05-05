package com.chipichapa.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chipichapa.hospital.model.SpecialDepartment;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialDepartmentRepository extends JpaRepository<SpecialDepartment, Long> {
}
