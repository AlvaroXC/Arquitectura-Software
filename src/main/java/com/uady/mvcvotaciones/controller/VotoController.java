package com.uady.mvcvotaciones.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.uady.mvcvotaciones.model.Voto;

public class VotoController {

    private Voto voto;
    private String path;

    public VotoController(String path){
        this.path= path;
    }

    public VotoController(Voto voto, String path){
        this.voto= voto;
        this.path= path;
    }

    public int obtenerTotalVotaciones() {
        
        int totalVotos=0; 

        try {
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                totalVotos++;
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return totalVotos;
    }


    public void escribirVotaciones() {
        try {
            FileWriter myWriter = new FileWriter(path, true);
            
            myWriter.write(voto.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME) + "\n");
            
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir las votaciones.");
            e.printStackTrace();
        }
    }

    
}
