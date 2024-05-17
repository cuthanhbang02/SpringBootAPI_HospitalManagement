package com.chipichapa.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chipichapa.hospital.model.WorkShift;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkShiftRepository extends JpaRepository<WorkShift, Long> {
    List<WorkShift> findWorkShiftByStaffsId(Long staffId);
}
