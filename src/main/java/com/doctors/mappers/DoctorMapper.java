package com.doctors.mappers;

import com.doctors.entities.DoctorEntity;
import com.doctors.models.DoctorDto;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DoctorMapper {
    public DoctorEntity toEntity(DoctorDto dto) {
        var entity = new DoctorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setSpecialization(dto.getSpecialization());
        entity.setLicenseNumber(dto.getLicenseNumber());
        entity.setContactNumber(dto.getContactNumber());
        entity.setCreatedAt(LocalDateTime.now());
        return entity;
    }

    public DoctorDto toDto(DoctorEntity entity) {
        var dto = new DoctorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setSpecialization(entity.getSpecialization());
        dto.setLicenseNumber(entity.getLicenseNumber());
        dto.setContactNumber(entity.getContactNumber());
        return dto;
    }

}
