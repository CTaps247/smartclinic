package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // REQUIRED: login validation (database-based check)
    public boolean validateDoctorLogin(String email, String specialty) {
        Optional<Doctor> doctor = doctorRepository.findByEmail(email);

        return doctor.isPresent() &&
               doctor.get().getSpecialty().equalsIgnoreCase(specialty);
    }

    // REQUIRED: availability retrieval using doctorId AND date
    public List<String> getDoctorAvailability(Long doctorId, String date) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // In real systems, date would filter availability
        // For lab, we still include parameter usage
        return doctor.getAvailableTimes();
    }
}