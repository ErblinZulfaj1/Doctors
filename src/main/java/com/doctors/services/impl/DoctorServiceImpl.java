package com.doctors.services.impl;

import com.doctors.entities.DoctorEntity;
import com.doctors.mappers.DoctorMapper;
import com.doctors.models.DoctorDto;
import com.doctors.repositories.DoctorRepository;
import com.doctors.services.DoctorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository repository;
    private DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorRepository repository, DoctorMapper doctorMapper) {
        this.repository = repository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public void add(DoctorDto doctorDto) {
        var entity = doctorMapper.toEntity(doctorDto);
        repository.save(entity);
    }

    @Override
    public void modify(long id, DoctorDto updatedDoctotDto) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty())
            throw new RuntimeException("Report case not found");

        var entity = optionalEntity.get();
        entity.setId(updatedDoctotDto.getId());
        entity.setName(updatedDoctotDto.getName());
        entity.setSurname(updatedDoctotDto.getSurname());
        entity.setSpecialization(updatedDoctotDto.getSpecialization());
        entity.setLicenseNumber(updatedDoctotDto.getLicenseNumber());
        entity.setContactNumber(updatedDoctotDto.getContactNumber());
        entity.setCreatedAt(LocalDateTime.now());
        repository.save(entity);
    }

    @Override
    public void removeById(long id) {
        repository.deleteById(id);
    }

    @Override
    public DoctorDto findById(long id) {
        var entity = repository.findById(id);
        if (entity.isEmpty())
            throw new RuntimeException("Doctor doesnt excists!");
        var dto = doctorMapper.toDto(entity.get());
        return dto;
    }

    @Override
    public List<DoctorDto> findAll() {
        return repository.findAll().stream().map(doctorMapper::toDto).toList();
    }
}
