package com.smartclinic.model;

import jakarta.persistence.*;
import java.util.List;

/**

* Doctor entity represents a doctor in the Smart Clinic system.
* It stores personal details, specialization, and availability schedule.
  */
  @Entity
  @Table(name = "doctors")
  public class Doctor {

  /**

  * Unique identifier for each doctor.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  /**

  * Full name of the doctor.
    */
    @Column(nullable = false)
    private String name;

  /**

  * Medical specialty (e.g., Cardiology, Dermatology).
    */
    @Column(nullable = false)
    private String specialty;

  /**

  * Unique email used for login authentication.
    */
    @Column(nullable = false, unique = true)
    private String email;

  /**

  * Password for doctor login (should be encrypted in production).
    */
    private String password;

  /**

  * List of available time slots for appointments.
    */
    @ElementCollection
    @CollectionTable(
    name = "doctor_available_times",
    joinColumns = @JoinColumn(name = "doctor_id")
    )
    @Column(name = "available_time")
    private List<String> availableTimes;

  /**

  * List of appointments associated with this doctor.
    */
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

  /**

  * Default constructor required by JPA.
    */
    public Doctor() {}

  /**

  * Constructor to initialize doctor object.
    */
    public Doctor(String name, String specialty, String email, String password) {
    this.name = name;
    this.specialty = specialty;
    this.email = email;
    this.password = password;
    }

  // ---------------- GETTERS AND SETTERS ----------------

  public Long getId() {
  return id;
  }

  public void setId(Long id) {
  this.id = id;
  }

  public String getName() {
  return name;
  }

  public void setName(String name) {
  this.name = name;
  }

  public String getSpecialty() {
  return specialty;
  }

  public void setSpecialty(String specialty) {
  this.specialty = specialty;
  }

  public String getEmail() {
  return email;
  }

  public void setEmail(String email) {
  this.email = email;
  }

  public String getPassword() {
  return password;
  }

  public void setPassword(String password) {
  this.password = password;
  }

  public List<String> getAvailableTimes() {
  return availableTimes;
  }

  public void setAvailableTimes(List<String> availableTimes) {
  this.availableTimes = availableTimes;
  }

  public List<Appointment> getAppointments() {
  return appointments;
  }

  public void setAppointments(List<Appointment> appointments) {
  this.appointments = appointments;
  }
  }
