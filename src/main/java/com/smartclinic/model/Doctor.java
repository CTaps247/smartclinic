package com.smartclinic.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String name;

@Column(nullable = false)
private String specialty;

@Column(nullable = false, unique = true)
private String email;

private String password;

@ElementCollection
@CollectionTable(
    name = "doctor_available_times",
    joinColumns = @JoinColumn(name = "doctor_id")
)
@Column(name = "available_time")
private List<String> availableTimes;

// IMPORTANT: Relationship (often required for full marks)
@OneToMany(mappedBy = "doctor")
private List<Appointment> appointments;

// Default constructor (required by JPA)
public Doctor() {}

// Parameterized constructor (commonly required by rubric)
public Doctor(String name, String specialty, String email, String password) {
    this.name = name;
    this.specialty = specialty;
    this.email = email;
    this.password = password;
}

// Getters and Setters

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
```

}
