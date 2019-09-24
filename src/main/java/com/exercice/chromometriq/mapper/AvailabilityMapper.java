package com.exercice.chromometriq.mapper;

import com.exercice.chromometriq.domain.Appointment;
import com.exercice.chromometriq.dto.AvailabilityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AvailabilityMapper {
    AvailabilityMapper INSTANCE = Mappers.getMapper(AvailabilityMapper.class);

    @Mapping(source = "timeSlot.start", target = "start")
    @Mapping(source = "timeSlot.end", target = "end")
    AvailabilityDto availabilityToAvailabilityDto(Appointment appointment);

    List<AvailabilityDto> availabilitiesToAvailabilitiesDto(List<Appointment> appointment);
}
