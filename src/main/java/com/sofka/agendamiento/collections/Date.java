package com.sofka.agendamiento.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "agendamiento")
@Data
public class Date {

    @Id
    private String id;
    private LocalDateTime date;
    private String address;
    private String agent;
    private String  appointment_type;
    private String document;
    private String state;

    public Date(LocalDateTime date,
                String address,
                String agent,
                String appointment_type,
                String document,
                String state) {
        this.date = date;
        this.address = address;
        this.agent = agent;
        this.appointment_type = appointment_type;
        this.document = document;
        this.state = state;
    }

    public Date() {
    }
}
