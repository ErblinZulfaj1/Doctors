package com.doctors.controllers;

import com.doctors.models.DoctorDto;
import com.doctors.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorDto> getAllDoctors() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public DoctorDto getById(@PathVariable long id) {
        return doctorService.findById(id);
    }

    @PostMapping
    public void addDoctor(@RequestBody DoctorDto newDoctor) {
        doctorService.add(newDoctor);
    }

    @PutMapping("/{id}")
    public void updatedDoctor(@PathVariable long id, @RequestBody DoctorDto updatedDoctor) {
        doctorService.modify(id, updatedDoctor);
    }



    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable long id) {
        doctorService.removeById(id);
    }

}
