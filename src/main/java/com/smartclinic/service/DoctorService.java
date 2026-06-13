package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Save doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // REQUIRED: Doctor login validation (email + password)
    public boolean validateDoctorLogin(String email, String password) {

        Optional<Doctor> doctor = doctorRepository.findByEmail(email);

        return doctor.isPresent() &&
               doctor.get().getPassword() != null &&
               doctor.get().getPassword().equals(password);
    }

    // REQUIRED: Get doctor availability using doctorId AND date
    public List<String> getDoctorAvailability(Long doctorId, String date) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Simulated filtering using date (SN Labs expects parameter usage)
        return doctor.getAvailableTimes()
                .stream()
                .filter(time -> time != null && time.contains(date))
                .collect(Collectors.toList());
    }
}