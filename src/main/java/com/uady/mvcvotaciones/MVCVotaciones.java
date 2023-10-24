package com.uady.mvcvotaciones;

import com.uady.mvcvotaciones.controller.VotoController;

// import com.uady.mvcvotaciones.controller.FileController;

public class MVCVotaciones {

    public static void main(String[] args) {
        // FileController fileController = new FileController("");
        // fileController.read();
        
        String PATH_VOTO_SANDIA= "src/main/resources/votaciones_sandia.txt";
        String PATH_VOTO_MANZANA= "src/main/resources/votaciones_manzana .txt";
        String PATH_VOTO_PERA= "src/main/resources/votaciones_pera.txt";

        VotoController votoControllerSandia= new VotoController(PATH_VOTO_SANDIA);
        System.out.println(votoControllerSandia.obtenerTotalVotaciones());

        VotoController votoControllerManzana = new VotoController(PATH_VOTO_MANZANA);
        System.out.println(votoControllerManzana.obtenerTotalVotaciones());

        VotoController votoControllerPera = new VotoController(PATH_VOTO_PERA);
        System.out.println(votoControllerPera.obtenerTotalVotaciones());


        
    }
}


