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
