package com.uady.mvcvotaciones.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.uady.mvcvotaciones.model.Producto;
import com.uady.mvcvotaciones.model.Voto;

public class FileController {
    private String path;

    //se le pasa la ruta del archivo de votaciones de un producto
    public FileController(String path) {
        this.path = path;
    }

    public ArrayList<Voto> leerVotaciones(ArrayList<Producto> productos) {
        ArrayList<Voto> votaciones = new ArrayList<>();
        try {
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String productName = parts[0];
                    // int votes = Integer.parseInt(parts[1]);

                    for (Producto producto : productos) {
                        if (producto.getName().equals(productName)) {
                            Voto votacion = new Voto(producto);
                            // votacion.votarNVeces(votes);
                            votaciones.add(votacion);
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de votaciones. Se creará uno nuevo.");
        }
        return votaciones;
    }

    public void escribirVotaciones(ArrayList<Voto> votaciones) {
        try {
            FileWriter myWriter = new FileWriter(path);
            for (Voto votacion : votaciones) {
                myWriter.write(votacion.getProducto().getName() + ":" + votacion.getVotos() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir las votaciones.");
            e.printStackTrace();
        }
    }
}
