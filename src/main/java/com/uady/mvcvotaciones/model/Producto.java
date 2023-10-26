package com.uady.mvcvotaciones.model;

public class Producto {
    private String name;

    public Producto(String name){
        this.name= name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
