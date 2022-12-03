package com.Doctor.repository;

import com.Doctor.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoctorRepository extends MongoRepository<Doctor , Long> {

    

    List<Doctor> findByName(String name);

    List<Doctor> findBySpecialization(String specialization);

    Doctor findByEmailid(String tempemailid);

    Doctor findByMobileno(String tempmobileno);
}
