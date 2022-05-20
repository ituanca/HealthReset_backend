package com.example.healthreset.utils;

import com.example.healthreset.model.StatusRoutine;
import com.example.healthreset.model.dto.StatusRoutineDTO;

public class StatusRoutineMapper {

    public StatusRoutine convertDTOtoStatusRoutine(StatusRoutineDTO statusRoutineDTO) {
        return StatusRoutine.builder()
                .statusRoutine(statusRoutineDTO.getStatusRoutine())
                .build();
    }

    public StatusRoutineDTO convertStatusRoutineToDTO(StatusRoutine statusRoutine) {
        return StatusRoutineDTO.builder()
                .statusRoutine(statusRoutine.getStatusRoutine())
                .build();
    }

}
