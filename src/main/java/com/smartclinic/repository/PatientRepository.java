@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Find patient by email address
     */
    Optional<Patient> findByEmail(String email);

    /**
     * Find patient by phone number
     */
    Optional<Patient> findByPhone(String phone);

    /**
     * Find patient by email or phone
     */
    Optional<Patient> findByEmailOrPhone(String email, String phone);

    List<Patient> findAllByEmail(String email);
}