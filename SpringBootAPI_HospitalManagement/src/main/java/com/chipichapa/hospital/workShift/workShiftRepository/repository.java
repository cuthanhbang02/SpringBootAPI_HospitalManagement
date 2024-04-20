package com.chipichapa.hospital.workShift.workShiftRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chipichapa.hospital.workShift.WorkShift;
public interface repository extends JpaRepository<WorkShift, Long> {
}
