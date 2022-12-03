package com.Appointment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Document(collection = "appointment")
public class Appointment {

    @Transient
    public static final String SEQUENCE_NAME ="user_sequence";


    @Id
    private long id;

    private long docid;
    private long patid;
    @JsonFormat(pattern = "yyyy-mm-dd",shape = JsonFormat.Shape.STRING)
    private String appdate;
    private String symptoms;
}
