package com.Appointment.controller;

import com.Appointment.entity.Appointment;
import com.Appointment.service.AppointmentService;
import com.Appointment.service.SequenceGeneratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/addappointments")
    public ResponseEntity<Appointment> addapp(@RequestBody @Valid Appointment app) throws Exception {

        return new ResponseEntity<>(appointmentService.addapp(app), HttpStatus.CREATED);
    }

}
