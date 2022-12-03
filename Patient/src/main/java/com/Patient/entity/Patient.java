package com.Patient.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Data

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

@Document(collection = "patient")
public class Patient {

    @Transient
    public static final String SEQUENCE_NAME ="user_sequence";
    @Id

    private long id;

    @NotBlank(message = "name is required")
    private String name;

    @Email(message = "invalid emailid")
    private String emailid;


    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String mobileno;

    @NotBlank(message = "Password is required")
    private String password;
}
