package com.Patient.service;

import com.Patient.entity.Patient;
import com.Patient.exception.ExceptionHandling;
import com.Patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public Patient savePatient(Patient patient)throws ExceptionHandling {

        Patient patient1 = null;
        String tempemailid = patient.getEmailid();

        if (tempemailid != null && !"".equals(tempemailid)) {
            patient1 = patientRepository.findByEmailid(tempemailid);
            if (patient1 != null) {
                throw new ExceptionHandling("patient with " + tempemailid + "is already exists");
            }
        }

        String tempmobilno=patient.getMobileno();

        if(tempmobilno!=null && !"".equals(tempmobilno)){
            patient1=patientRepository.findByMobileno(tempmobilno);
            if(patient1!=null){
                throw new ExceptionHandling("patient with "+tempmobilno+"is already exists");
            }
        }

        patient.setId(sequenceGeneratorService.generateSequence(Patient.SEQUENCE_NAME));
        patient1 = patientRepository.save(patient);
        return patient1;
    }

    public List<Patient> getAllPatients(){

        return patientRepository.findAll();
    }

}
