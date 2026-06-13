package com.smartclinic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllPrescriptions() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "List of prescriptions endpoint working");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{token}")
    public ResponseEntity<Map<String, String>> addPrescription(
            @RequestBody Prescription prescription,
            @PathVariable String token) {

        Map<String, String> response = new HashMap<>();

        // simple token check (you can replace with service logic if required)
        if (token == null || token.isEmpty()) {
            response.put("error", "Invalid token");
            return ResponseEntity.status(401).body(response);
        }

        response.put("message", "Prescription added successfully");
        return ResponseEntity.ok(response);
    }
}