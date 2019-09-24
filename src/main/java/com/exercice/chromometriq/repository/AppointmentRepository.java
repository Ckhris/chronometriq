package com.exercice.chromometriq.repository;

import com.exercice.chromometriq.domain.Appointment;
import com.exercice.chromometriq.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    @Query("select a from Appointment a where a.doctor = :doctor and a.patient is null and a.date between :start and :end")
    List<Appointment> findAllByDoctorIdAndPatientIsNullAndDateBetween(Long doctorId, LocalDate start, LocalDate end);

    Optional<Appointment> findByIdAndDoctorIdAndPatientIsNull(Long appointmendId, Long doctorId);
}
