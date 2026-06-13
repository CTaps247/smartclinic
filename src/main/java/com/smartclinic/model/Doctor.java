package com.smartclinic.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

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

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    @ElementCollection
    @CollectionTable(
        name = "doctor_available_times",
        joinColumns = @JoinColumn(name = "doctor_id")
    )
    @Column(name = "available_time")
    private List<String> availableTimes;

    public Doctor() {}

    // getters & setters
}