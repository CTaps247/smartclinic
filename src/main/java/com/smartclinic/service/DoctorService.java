package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor saveDoctor(Doctor doctor);
}