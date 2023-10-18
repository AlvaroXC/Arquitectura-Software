package com.uady.mvcvotaciones.controller;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.ArrayList;
// import java.util.Scanner;

// import com.uady.mvcvotaciones.model.Producto;
// import com.uady.mvcvotaciones.model.Voto;

public class FileController {
    // private String path;

    // //se le pasa la ruta del archivo de votaciones de un producto
    // public FileController(String path) {
    //     this.path = path;
    // }

    //     public ArrayList<Voto> leerVotaciones(ArrayList<Producto> productos) {
    //     ArrayList<Voto> votaciones = new ArrayList<>();
    //     try {
    //         File myFile = new File(path);
    //         Scanner myReader = new Scanner(myFile);
    //         while (myReader.hasNextLine()) {
    //             String line = myReader.nextLine();
    //             String[] parts = line.split(":");
    //             if (parts.length == 3) {
    //                 String productName = parts[0];
    //                 int votes = Integer.parseInt(parts[1]);
    //                 String dateTimeStr = parts[2];

    //                 for (Producto producto : productos) {
    //                     if (producto.getName().equals(productName)) {
    //                         Voto votacion = new Voto(producto);
    //                         votacion.setVotos(votes);
    //                         votacion.setDateTime(LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_DATE_TIME));
    //                         votaciones.add(votacion);
    //                     }
    //                 }
    //             }
    //         }
    //         myReader.close();
    //     } catch (FileNotFoundException e) {
    //         System.out.println("No se encontró el archivo de votaciones. Se creará uno nuevo.");
    //     }
    //     return votaciones;
    // }

    // public void escribirVotaciones(Voto voto) {
    //     try {
    //         FileWriter myWriter = new FileWriter(path, true);
            
    //         myWriter.write(voto.getVotos() + ":" + voto.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME) + "\n");
            
    //         myWriter.close();
    //     } catch (IOException e) {
    //         System.out.println("Error al escribir las votaciones.");
    //         e.printStackTrace();
    //     }
    // }
}
