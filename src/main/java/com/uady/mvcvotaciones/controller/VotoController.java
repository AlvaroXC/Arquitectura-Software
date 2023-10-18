package com.uady.mvcvotaciones.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import com.uady.mvcvotaciones.model.Voto;

public class VotoController {

    private Voto voto;
    private String path;

    public VotoController(Voto voto, String path){
        this.voto= voto;
        this.path= path;
    }


    public void escribirVotaciones() {
        try {
            FileWriter myWriter = new FileWriter(path, true);
            
            myWriter.write(voto.getVotos() + ":" + voto.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME) + "\n");
            
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir las votaciones.");
            e.printStackTrace();
        }
    }

    
}
