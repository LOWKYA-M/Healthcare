package com.Patient.controller;

import com.Patient.entity.Patient;
import com.Patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<Patient> savePatient(@RequestBody @Valid Patient patient) throws Exception {

        return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients(){

        return ResponseEntity.ok(patientService.getAllPatients());
    }
}
