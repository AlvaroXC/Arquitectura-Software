package com.uady.mvcvotaciones.model;

import java.time.LocalDate;

public class Producto {
    
    private String name;
    private LocalDate localDate;

    public Producto(String name, LocalDate localDate){
        this.name= name;
        this.localDate = localDate;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    
    
}
