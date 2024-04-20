package com.chipichapa.hospital.specialDepartment.specialDepartmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chipichapa.hospital.specialDepartment.SpecialDepartment;
public interface repository extends JpaRepository<SpecialDepartment, Long> {
}
