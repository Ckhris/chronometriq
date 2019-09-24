package com.exercice.chromometriq.controller;

import com.exercice.chromometriq.domain.Appointment;
import com.exercice.chromometriq.domain.Doctor;
import com.exercice.chromometriq.dto.AvailabilityDto;
import com.exercice.chromometriq.dto.TimeSlotDto;
import com.exercice.chromometriq.request.BookAppointment;
import com.exercice.chromometriq.service.DoctorService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/clinic")
@Slf4j
public class ClinicController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity getDoctors(){
        List<Doctor> doctors;
        try {
            doctors = doctorService.findDoctors();
        } catch (Exception e){
            log.error("getDoctors() : An issue occured : {}", e.getMessage(), e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error, contact the administrator");
        }

        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @GetMapping("/doctors/{id}/appointment/{start}/{end}")
    public ResponseEntity getDoctorAvailability(@PathVariable("id") Long id,
                                                @PathVariable("start") LocalDate start,
                                                @PathVariable("end") LocalDate end){

        List<AvailabilityDto> doctorAvailability;
        try {
            doctorAvailability = doctorService.findDoctorAvailability(id, start, end);
        } catch (EntityNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No doctor with id "+id+" found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctorAvailability);
    }

    @PostMapping("/appointment")
    public ResponseEntity bookAppointment(@RequestBody BookAppointment bookAppointment){
        String response = doctorService.bookAppointment(bookAppointment);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
