package com.exercice.chromometriq.service;

import com.exercice.chromometriq.domain.Appointment;
import com.exercice.chromometriq.domain.Patient;
import com.exercice.chromometriq.repository.AppointmentRepository;
import com.exercice.chromometriq.repository.PatientRepository;
import com.exercice.chromometriq.request.BookAppointment;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private DoctorService doctorService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp(){}

    @Test
    public void bookAppointment_patientNotFound(){
        BookAppointment bookAppointment = BookAppointment.builder().patient(1L).build();
        exceptionRule.expect(EntityNotFoundException.class);
        exceptionRule.expectMessage("Patient not found");

        doctorService.bookAppointment(bookAppointment);
    }

    @Test
    public void bookAppointment_noAppointmentAvailable(){
        BookAppointment bookAppointment = BookAppointment.builder().doctor(1L).build();
        Patient patient = Patient.builder().id(1L).build();

        when(patientRepository.findById(bookAppointment.getPatient())).thenReturn(Optional.of(patient));
        when(appointmentRepository.findByIdAndDoctorIdAndPatientIsNull(bookAppointment.getAppointment(), bookAppointment.getDoctor())).thenReturn(Optional.empty());

        String result = doctorService.bookAppointment(bookAppointment);

        assertThat(result).isEqualTo("No appointment available");
        verify(patientRepository).findById(bookAppointment.getPatient());
        verify(appointmentRepository).findByIdAndDoctorIdAndPatientIsNull(bookAppointment.getAppointment(), bookAppointment.getDoctor());
    }

    @Test
    public void bookAppointment_success(){
        BookAppointment bookAppointment = BookAppointment.builder().doctor(1L).build();
        Patient patient = Patient.builder().id(1L).build();
        Appointment appointment = Appointment.builder().id(1L).build();

        when(patientRepository.findById(bookAppointment.getPatient())).thenReturn(Optional.of(patient));
        when(appointmentRepository.findByIdAndDoctorIdAndPatientIsNull(bookAppointment.getAppointment(), bookAppointment.getDoctor())).thenReturn(Optional.of(appointment));

        String result = doctorService.bookAppointment(bookAppointment);

        assertThat(result).isEqualTo("Appointment booked");
        assertThat(appointment.getPatient()).isEqualTo(patient);
        verify(patientRepository).findById(bookAppointment.getPatient());
        verify(appointmentRepository).findByIdAndDoctorIdAndPatientIsNull(bookAppointment.getAppointment(), bookAppointment.getDoctor());
    }
}
