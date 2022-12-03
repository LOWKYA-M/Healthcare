package com.Appointment.service;

import com.Appointment.entity.Appointment;
import com.Appointment.model.Doctor;
import com.Appointment.model.Patient;
import com.Appointment.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private RestTemplate restTemplate;


    public Appointment addapp(Appointment app) throws Exception
    {
        long tempdocid=app.getDocid();
        Doctor doctor=restTemplate.getForObject("http://DOCTOR-SERVICE/doctor/id/"+tempdocid, Doctor.class);

        if(doctor == null)
        {
            throw new Exception("Doctor is not available");
        }
        long temppatid=app.getPatid();
        Patient patient=restTemplate.getForObject("http://PATIENT-SERVICE/patient/id/"+temppatid, Patient.class);


        if(patient == null)
        {
            throw new Exception("Patient is not available");
        }

        app.setId(sequenceGeneratorService.generateSequence(Appointment.SEQUENCE_NAME));
        app=appointmentRepository.save(app);
        return app;
    }


}
