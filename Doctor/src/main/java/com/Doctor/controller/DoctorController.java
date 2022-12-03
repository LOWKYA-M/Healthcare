package com.Doctor.controller;

import com.Doctor.entity.Doctor;

import com.Doctor.service.DoctorService;
import com.Doctor.service.SequenceGeneratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/adddoctors")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody @Valid Doctor doctor) throws Exception {

        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(){

        return ResponseEntity.ok(doctorService.getAllDoctors());
    }


    @GetMapping("/name/{name}")
    public List<Doctor> getDoctorByName(@PathVariable String name)  {
        List<Doctor> doctor=doctorService.getDoctorByName(name);
        return doctor;
    }

    @GetMapping("/{specialization}")
    public List<Doctor> getDoctorBySpecialization(@PathVariable String specialization)  {
        List<Doctor> doctor =doctorService.getDoctorBySpecialization(specialization);
        return doctor;

    }

}
