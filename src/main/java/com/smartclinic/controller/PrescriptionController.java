package com.smartclinic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @GetMapping
    public String getAllPrescriptions() {
        return "List of prescriptions endpoint working";
    }

    @PostMapping
    public String addPrescription() {
        return "Prescription added successfully";
    }
}