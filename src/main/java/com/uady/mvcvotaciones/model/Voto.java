package com.uady.mvcvotaciones.model;

public class Voto {
    private Producto producto;
    private int votos;

    public Voto(Producto producto){
        this.producto= producto;
        this.votos= 0; 
    }

    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getVotos() {
        return votos;
    }
    
    public void votar(){
        votos++;
    }
}
