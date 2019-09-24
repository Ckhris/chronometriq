package com.exercice.chromometriq.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AvailabilityDto {
    Long id;
    LocalDate date;
    LocalTime start;
    LocalTime end;
}
