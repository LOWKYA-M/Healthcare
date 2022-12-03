package com.Appointment.model;

import com.Appointment.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Appointmentdetails {

    private Appointment appointment;
    private Doctor doctor;
    private Patient patient;
}
