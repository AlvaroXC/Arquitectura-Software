package com.uady.mvcvotaciones.model;

import java.time.LocalDateTime;

public class Voto {

    private int votos=0;
    private LocalDateTime dateTime;

    public Voto(){
        this.dateTime= LocalDateTime.now();
    }


    public int getVotos() {
        return votos;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    public void votar(){
        votos++;
    }
}
