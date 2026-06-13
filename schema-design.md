# Smart Clinic Database Design

## Patient

| Column | Type |
|----------|----------|
| patient_id | BIGINT |
| first_name | VARCHAR(100) |
| last_name | VARCHAR(100) |
| email | VARCHAR(255) |
| phone | VARCHAR(20) |

## Doctor

| Column | Type |
|----------|----------|
| doctor_id | BIGINT |
| first_name | VARCHAR(100) |
| last_name | VARCHAR(100) |
| specialty | VARCHAR(100) |
| email | VARCHAR(255) |

## Appointment

| Column | Type |
|----------|----------|
| appointment_id | BIGINT |
| patient_id | BIGINT |
| doctor_id | BIGINT |
| appointment_date | DATETIME |
| status | VARCHAR(50) |

## Prescription

| Column | Type |
|----------|----------|
| prescription_id | BIGINT |
| patient_id | BIGINT |
| doctor_id | BIGINT |
| medication | VARCHAR(255) |
| dosage | VARCHAR(100) |
