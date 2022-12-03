package com.Doctor.service;

import com.Doctor.exception.ExceptionHandling;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Doctor.entity.Doctor;
import com.Doctor.repository.DoctorRepository;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    public Doctor saveDoctor(Doctor doctor) throws ExceptionHandling {

        Doctor doctor1=null;

        String tempemailid =doctor.getEmailid();

        if(  tempemailid!=null && !"".equals(tempemailid)){
            doctor1=doctorRepository.findByEmailid(tempemailid);
            if(doctor1 !=null) {
                throw new ExceptionHandling("doctor with "+tempemailid+"is already exists");
            }
        }

        String tempmobilno=doctor.getMobileno();

        if(tempmobilno!=null && !"".equals(tempmobilno)){
            doctor1=doctorRepository.findByMobileno(tempmobilno);
            if(doctor1!=null){
                throw new ExceptionHandling("doctor with "+tempmobilno+"is already exists");
            }
        }

        doctor.setId(sequenceGeneratorService.generateSequence(Doctor.SEQUENCE_NAME));
        doctor1= doctorRepository.save(doctor);
        log.info("doctor {} is created", doctor.getName());
        return doctor1;


    }
    public List<Doctor> getAllDoctors(){

        return doctorRepository.findAll();
    }
    public List<Doctor> getDoctorByName(String name) {
        List<Doctor> doctor = doctorRepository.findByName(name);
            return doctor;

    }

    public List<Doctor> getDoctorBySpecialization(String specialization)   {
        List<Doctor> doctor = doctorRepository.findBySpecialization(specialization);
            return doctor;


    }
}
