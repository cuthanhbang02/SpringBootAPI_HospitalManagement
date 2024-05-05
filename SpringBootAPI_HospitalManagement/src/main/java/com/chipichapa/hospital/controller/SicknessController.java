package com.chipichapa.hospital.controller;

import com.chipichapa.hospital.model.Sickness;
import com.chipichapa.hospital.exception.Exception;
import com.chipichapa.hospital.repository.SicknessRepository;
import com.chipichapa.hospital.standardization.Standardization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class SicknessController
{
    @Autowired
    private SicknessRepository sicknessRepository;

    //get request methods
    @GetMapping("/sicknesses")
    public List<Sickness> getAllSicknesses()
    {
        return  sicknessRepository.findAll();
    }

    @GetMapping("/sicknesses/{id}")
    public ResponseEntity<Sickness> getSicknessByID(@PathVariable(name = "id") Long id)
    {
        Sickness sickness = sicknessRepository.findById(id)
                .orElseThrow(()-> new Exception("Sickness with id" + id + "not exist"));
        return ResponseEntity.ok(sickness);
    }

    /*@GetMapping("/sicknesses/:name")
    public  List<Sickness> getSicknessByName(@PathVariable(name="sickName") String sickName)
    {
        Standardization standardization = new Standardization();
        sickName = standardization.StandardSpace(sickName);
        return sicknessRepository.findAllBySickName(sickName);
    }*/

    //post request methods
    @PostMapping("/sicknesses/add")
    public Sickness postSickness(@RequestBody Sickness sickness)
    {
        Standardization standardization = new Standardization();
        sickness.setSickName(standardization.StandardSpace(sickness.getSickName()));
        return sicknessRepository.save(sickness);
    }

    //put request methods
    @PutMapping("/sicknesses/update/{id}")
    public ResponseEntity<Sickness> putSicknessThroughID (@PathVariable(name = "id") Long id, @RequestBody Sickness newSickness)
    {
        Sickness sickness = sicknessRepository.findById(id)
                .orElseThrow(()-> new Exception("Sickness with id" + id + "not exist"));
        sickness.setSickName(newSickness.getSickName());
        sickness.setMedicalForms(newSickness.getMedicalForms());
        return ResponseEntity.ok(sickness);
    }

    //delete request methods
    @DeleteMapping("/sicknesses/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteThroughID (@PathVariable(name = "id") Long id)
    {
        Sickness sickness = sicknessRepository.findById(id)
                .orElseThrow(()-> new Exception("Sickness with id" + id + "not exist"));
        sicknessRepository.delete(sickness);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /*@DeleteMapping("/sicknesses/")
    public ResponseEntity<Map<String,Boolean>> deleteAllSickness()
    {
        sicknessRepository.deleteAll(sicknessRepository.findAll());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }*/

}
