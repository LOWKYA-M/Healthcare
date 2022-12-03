package com.Doctor.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class AddDoctor {

    private String name;
    private String emailid;
    private String mobileno;
    private String specialization;
    private String experience;
    private String password;
}
