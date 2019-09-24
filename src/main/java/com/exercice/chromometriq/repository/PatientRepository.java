package com.exercice.chromometriq.repository;

import com.exercice.chromometriq.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
