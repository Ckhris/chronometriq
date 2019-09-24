package com.exercice.chromometriq.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Appointment {

    @Id
    private Long id;
    private LocalDate date;
    @ManyToOne
    private TimeSlot timeSlot;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
}
