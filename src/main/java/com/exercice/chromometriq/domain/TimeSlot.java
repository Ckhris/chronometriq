package com.exercice.chromometriq.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TimeSlot {
    @Id
    private Long id;
    private LocalTime start;
    private LocalTime end;
}
