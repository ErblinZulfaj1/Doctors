package com.doctors.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private long id;
    private String name;
    private String surname;
    private String specialization;
    private String licenseNumber;
    private String contactNumber;
    private String email;
}
