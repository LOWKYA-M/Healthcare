package com.Appointment.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

@Document(collection = "doctor")
public class Doctor {


    @Transient
    public static final String SEQUENCE_NAME ="user_sequence";



    @Id
    private long id;

    @NotBlank(message = "name is required")
    private String name;

    @Email(message = "invalid emailid")
    private String emailid;


    @Indexed(unique = true)
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String mobileno;
    @NotBlank(message = "specialization is required")
    private String specialization;
    @Min(1)
    @Max(100)
    private String experience;



}
