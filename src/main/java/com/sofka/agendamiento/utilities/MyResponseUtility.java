package com.sofka.agendamiento.utilities;

import org.springframework.stereotype.Component;

@Component
public class MyResponseUtility {
    public Boolean error;
    public String message;
    public Object data;

    public MyResponseUtility() {
        error = false;
        message = "Success";
        data = null;
    }

    public MyResponseUtility(Boolean error, String message, Object data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public MyResponseUtility(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

}
