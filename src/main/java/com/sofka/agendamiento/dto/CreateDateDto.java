package com.sofka.agendamiento.dto;

import com.sofka.agendamiento.utilities.type_enum.Appointment_type;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;
import java.time.LocalDateTime;

@Data
@ValidateOnExecution
@AllArgsConstructor
public class CreateDateDto {

    @NotNull(message = "The date is require")
    private LocalDateTime date;

    @NotNull(message = "The address is required")
    private String address;

    @NotNull(message = "The agent is required")
    private String agent;

    @NotNull(message = "The appointment_type is required")
    private Appointment_type appointment_type;

    @NotNull(message = "The document name is required")
    private String document;


}
