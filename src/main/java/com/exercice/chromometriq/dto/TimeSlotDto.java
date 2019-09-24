package com.exercice.chromometriq.dto;

import com.exercice.chromometriq.domain.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TimeSlotDto {
    private LocalDate date;
    private List<TimeSlot> timeSlots;
}
