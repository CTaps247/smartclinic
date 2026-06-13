package com.smartclinic.controller;

import com.smartclinic.model.Doctor;
import com.smartclinic.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    // Get all doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(service.getAllDoctors());
    }

    // Add doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(service.saveDoctor(doctor));
    }

    // Get doctor availability (secured endpoint)
    @GetMapping("/availability/{user}/{doctorId}/{date}/{token}")
    public ResponseEntity<?> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        Map<String, Object> response = new HashMap<>();

        // Validate token
        if (!service.validateToken(token, user)) {
            response.put("status", "error");
            response.put("message", "Invalid token");
            return ResponseEntity.status(401).body(response);
        }

        // Fetch availability
        response.put("status", "success");
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("availability", service.getDoctorAvailability(doctorId, date));

        return ResponseEntity.ok(response);
    }
}