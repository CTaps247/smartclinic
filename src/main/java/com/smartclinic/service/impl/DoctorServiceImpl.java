package com.smartclinic.service.impl;

import com.smartclinic.model.Doctor;
import com.smartclinic.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final List<Doctor> doctors = new ArrayList<>();

    @Override
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }
}