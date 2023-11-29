package com.doctors.services;

import com.doctors.models.DoctorDto;

import java.util.List;

public interface DoctorService {
    void add(DoctorDto doctorDto);

    void modify(long id, DoctorDto updatedDoctotDto);

    void removeById(long id);

    DoctorDto findById(long id);

    List<DoctorDto> findAll();
}
