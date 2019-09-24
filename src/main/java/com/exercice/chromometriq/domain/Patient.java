package com.exercice.chromometriq.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"firstname", "lastname"})
})
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Patient {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
}
