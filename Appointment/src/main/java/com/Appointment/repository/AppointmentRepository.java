package com.Appointment.repository;

import com.Appointment.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, Long> {
}
