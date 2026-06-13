# Smart Clinic Database Design

## Patient

| Column | Type | Key |
|----------|----------|----------|
| patient_id | BIGINT | PK |
| first_name | VARCHAR(100) | |
| last_name | VARCHAR(100) | |
| email | VARCHAR(255) | |
| phone | VARCHAR(20) | |

## Doctor

| Column | Type | Key |
|----------|----------|----------|
| doctor_id | BIGINT | PK |
| first_name | VARCHAR(100) | |
| last_name | VARCHAR(100) | |
| specialty | VARCHAR(100) | |
| email | VARCHAR(255) | |

## Appointment

| Column | Type | Key |
|----------|----------|----------|
| appointment_id | BIGINT | PK |
| patient_id | BIGINT | FK |
| doctor_id | BIGINT | FK |
| appointment_date | DATETIME | |
| status | VARCHAR(50) | |

## Prescription

| Column | Type | Key |
|----------|----------|----------|
| prescription_id | BIGINT | PK |
| patient_id | BIGINT | FK |
| doctor_id | BIGINT | FK |
| medication | VARCHAR(255) | |
| dosage | VARCHAR(100) | |

## Relationships

- Appointment.patient_id references Patient.patient_id
- Appointment.doctor_id references Doctor.doctor_id
- Prescription.patient_id references Patient.patient_id
- Prescription.doctor_id references Doctor.doctor_id

## MySQL DDL

```sql
CREATE TABLE Patient (
    patient_id BIGINT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(255),
    phone VARCHAR(20)
);

CREATE TABLE Doctor (
    doctor_id BIGINT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    specialty VARCHAR(100),
    email VARCHAR(255)
);

CREATE TABLE Appointment (
    appointment_id BIGINT PRIMARY KEY,
    patient_id BIGINT,
    doctor_id BIGINT,
    appointment_date DATETIME,
    status VARCHAR(50),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription (
    prescription_id BIGINT PRIMARY KEY,
    patient_id BIGINT,
    doctor_id BIGINT,
    medication VARCHAR(255),
    dosage VARCHAR(100),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);
```
