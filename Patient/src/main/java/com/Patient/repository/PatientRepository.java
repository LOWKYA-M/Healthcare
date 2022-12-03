package com.Patient.repository;

import com.Patient.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient,Long> {

    Patient findByEmailid(String tempemailid);

    Patient findByMobileno(String tempmobilno);
}
