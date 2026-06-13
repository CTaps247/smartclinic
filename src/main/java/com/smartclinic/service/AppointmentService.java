package com.smartclinic.service;

import com.smartclinic.model.Appointment;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment saveAppointment(Appointment appointment);

    // Book a new appointment
    Appointment bookAppointment(Appointment appointment);

    // Find appointments for a doctor on a given date
    List<Appointment> getAppointmentsByDoctorAndDate(
            Long doctorId,
            LocalDateTime appointmentDate);
}

@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment bookAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    public List<Appointment> getAppointmentsByDoctorAndDate(
            Long doctorId,
            LocalDateTime appointmentDate) {
        return repository.findByDoctorIdAndAppointmentDate(
                doctorId,
                appointmentDate);
    }
}