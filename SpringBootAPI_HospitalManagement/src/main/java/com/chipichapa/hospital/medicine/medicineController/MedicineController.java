package com.chipichapa.hospital.medicine.medicineController;

import com.chipichapa.hospital.exception.Exception;
import com.chipichapa.hospital.medicine.medicineModel.Medicine;
import com.chipichapa.hospital.medicine.medicineRepository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/medicine")
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }

    @PostMapping("/medicine")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineRepository.save(medicine);
    }

    @GetMapping("/medicine/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id){
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new Exception("Medicine not exist with id:" + id));
        return ResponseEntity.ok(medicine);
    }

    @PutMapping("/medicine/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails){
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new Exception("Medicine not exist with id:" + id));

        medicine.setName(medicineDetails.getName());
        medicine.setImportDate(medicineDetails.getImportDate());
        medicine.setShipment(medicineDetails.getShipment());
        medicine.setNumber(medicineDetails.getNumber());
        medicine.setExpiry(medicineDetails.getExpiry());

        Medicine updatedMedicine = medicineRepository.save(medicine);

        return ResponseEntity.ok(updatedMedicine);
    }

    @DeleteMapping("/medicine/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable Long id){
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new Exception("Medicine not exist with id:" + id));
        medicineRepository.delete(medicine);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
