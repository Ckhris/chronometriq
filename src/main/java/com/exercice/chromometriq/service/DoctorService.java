package com.exercice.chromometriq.service;

import com.exercice.chromometriq.domain.Appointment;
import com.exercice.chromometriq.domain.Doctor;
import com.exercice.chromometriq.domain.Patient;
import com.exercice.chromometriq.dto.AvailabilityDto;
import com.exercice.chromometriq.mapper.AvailabilityMapper;
import com.exercice.chromometriq.repository.AppointmentRepository;
import com.exercice.chromometriq.repository.DoctorRepository;
import com.exercice.chromometriq.repository.PatientRepository;
import com.exercice.chromometriq.request.BookAppointment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DoctorService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public List<Doctor> findDoctors() throws Exception {
        return doctorRepository.findAll();
    }

    public List<AvailabilityDto> findDoctorAvailability(Long doctorId, LocalDate start, LocalDate end) {
            List<Appointment> availabilities = appointmentRepository.findAllByDoctorIdAndPatientIsNullAndDateBetween(doctorId, start, end);
            return AvailabilityMapper.INSTANCE.availabilitiesToAvailabilitiesDto(availabilities);
    }

    public String bookAppointment(BookAppointment bookAppointment) {
        Optional<Patient> patient = patientRepository.findById(bookAppointment.getPatient());
        if(patient.isPresent()){
            Optional<Appointment> appointment = appointmentRepository.findByIdAndDoctorIdAndPatientIsNull(bookAppointment.getAppointment(), bookAppointment.getDoctor());
            if(appointment.isPresent()){
                appointment.get().setPatient(patient.get());
                appointmentRepository.save(appointment.get());
                return "Appointment booked";
            }
            return "No appointment available";
        }

        return "Patient not found";
    }

}
