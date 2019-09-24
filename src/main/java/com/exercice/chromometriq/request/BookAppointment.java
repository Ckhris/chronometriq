package com.exercice.chromometriq.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookAppointment {
    @NotNull
    private Long appointment;
    @NotNull
    private Long doctor;
    @NotNull
    private Long patient;
}
