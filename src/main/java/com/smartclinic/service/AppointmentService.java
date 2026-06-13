package com.smartclinic.service;

import com.smartclinic.model.Appointment;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment saveAppointment(Appointment appointment);
}