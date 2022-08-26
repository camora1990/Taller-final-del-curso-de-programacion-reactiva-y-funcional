package com.sofka.agendamiento.dto;

import com.sofka.agendamiento.utilities.type_enum.Appointment_type;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.executable.ValidateOnExecution;
import java.time.LocalDateTime;

@Data
@ValidateOnExecution
@AllArgsConstructor
public class UpdateDateDto {
    private LocalDateTime date;
    private String address;
    private String agent;
    private Appointment_type appointment_type;
    private String document;
}
