package com.smartclinic.service.impl;

import com.smartclinic.model.Appointment;
import com.smartclinic.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();

    @Override
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }
}