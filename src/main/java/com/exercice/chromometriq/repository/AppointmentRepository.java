package com.exercice.chromometriq.repository;

import com.exercice.chromometriq.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByDoctorIdAndPatientIsNullAndDateBetween(Long doctorId, LocalDate start, LocalDate end);

    Optional<Appointment> findByIdAndDoctorIdAndPatientIsNull(Long appointmendId, Long doctorId);
}
