package com.chipichapa.hospital.medicine.medicineRepository;

import com.chipichapa.hospital.medicine.medicineModel.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
