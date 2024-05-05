package com.chipichapa.hospital.controller;

import com.chipichapa.hospital.exception.Exception;
import com.chipichapa.hospital.model.Medicine;
import com.chipichapa.hospital.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }

    @PostMapping("/medicines/add")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineRepository.save(medicine);
    }

    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id){
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new Exception("Medicine not exist with id:" + id));
        return ResponseEntity.ok(medicine);
    }

    @PutMapping("/medicines/update/{id}")
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

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable (name ="id") Long id){
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new Exception("Medicine not exist with id:" + id));
        medicineRepository.delete(medicine);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
