package com.doctors.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Doctors")
public class DoctorEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
        private String surname;
        private String specialization;
        private String licenseNumber;
        private String contactNumber;
        private String email;
        private LocalDateTime date;
        private LocalDateTime createdAt = LocalDateTime.now();

    }
