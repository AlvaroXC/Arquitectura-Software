package com.uady.mvcvotaciones.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.uady.mvcvotaciones.model.Producto;

public class ProductoController {

    private final String PATH_PRODUCTOS= "src/main/resources/productos.txt";

    public ArrayList<Producto> cargarProductosDesdeArchivo() {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            File myFile = new File(PATH_PRODUCTOS);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String name = myReader.nextLine();
                productos.add(new Producto(name));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
