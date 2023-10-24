package com.uady.mvcvotaciones.model;

import java.time.LocalDateTime;

public class Voto {
    private LocalDateTime dateTime;

    public Voto(){
        this.dateTime= LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}