package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**

* Repository interface for managing Patient entities.
* Provides database access methods for patient-related operations.
  */
  @Repository
  public interface PatientRepository extends JpaRepository<Patient, Long> {

  /**

  * Retrieves a patient using their unique email address.
  *
  * @param email patient's email
  * @return Optional containing Patient if found
    */
    Optional<Patient> findByEmail(String email);

  /**

  * Retrieves a patient using their phone number.
  *
  * @param phone patient's phone number
  * @return Optional containing Patient if found
    */
    Optional<Patient> findByPhone(String phone);

  /**

  * Retrieves a patient using either email or phone number.
  *
  * @param email patient's email
  * @param phone patient's phone number
  * @return Optional containing Patient if found
    */
    Optional<Patient> findByEmailOrPhone(String email, String phone);
    }
