package com.smartclinic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @GetMapping
    public String getAllPrescriptions() {
        return "Prescription endpoint working";
    }
}