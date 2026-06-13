package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Required: find patient by email
    Optional<Patient> findByEmail(String email);

    // Required: find patient by phone number
    Optional<Patient> findByPhone(String phone);

    // Extra (often satisfies “email or phone” requirement)
    Optional<Patient> findByEmailOrPhone(String email, String phone);

    // Optional: multiple patients with same email domain etc.
    List<Patient> findAllByEmail(String email);
}