package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final TokenService tokenService;

    public DoctorService(
            DoctorRepository doctorRepository,
            TokenService tokenService) {
        this.doctorRepository = doctorRepository;
        this.tokenService = tokenService;
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Save doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Doctor login with JWT token generation.
     * Returns JWT token on success, error message on failure.
     */
    public ResponseEntity<?> login(String email, String password) {

        Optional<Doctor> doctor = doctorRepository.findByEmail(email);

        if (doctor.isPresent()
                && doctor.get().getPassword() != null
                && doctor.get().getPassword().equals(password)) {

            String token = tokenService.generateToken(email);

            return ResponseEntity.ok(token);
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid email or password");
    }

    /**
     * Retrieves doctor availability for a given date.
     * Uses explicit date matching for safer filtering.
     */
    public List<String> getDoctorAvailability(Long doctorId, LocalDate date) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        return doctor.getAvailableTimes()
                .stream()
                .filter(time -> {
                    if (time == null) return false;

                    String[] parts = time.split(" ");
                    return parts.length > 0 && parts[0].equals(date.toString());
                })
                .collect(Collectors.toList());
    }
}
