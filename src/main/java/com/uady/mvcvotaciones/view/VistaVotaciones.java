package com.uady.mvcvotaciones.view;

// import com.uady.mvcvotaciones.controller.FileController;
import com.uady.mvcvotaciones.controller.ProductoController;
import com.uady.mvcvotaciones.controller.VotoController;
import com.uady.mvcvotaciones.model.Producto;
import com.uady.mvcvotaciones.model.Voto;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.time.LocalDate;
import java.util.ArrayList;
// import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VistaVotaciones {

    private static String PATH_VOTO= "src/main/resources/votaciones_";
    public static void main(String[] args) {
        // Carga la lista de productos desde el archivo productos.txt
        ProductoController productoController = new ProductoController();
        ArrayList<Producto> productos = productoController.cargarProductosDesdeArchivo();

        // Carga las votaciones existentes desde el archivo votaciones.txt
        // ArrayList<Voto> votaciones = cargarVotacionesDesdeArchivo(productos, PATH_VOTACIONES);

        JFrame frame = new JFrame("Votación de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (Producto producto : productos) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel label = new JLabel(producto.getName());
            // JButton voteButton = new JButton("Votar por "+ producto.getName());
            JButton voteButton = new JButton("Votar por "+ producto.getName());
            voteButton.setName(producto.getName().toLowerCase());

            // Voto votacion = obtenerVotacion(producto, votaciones);

            voteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    System.out.println(voteButton.getName());
                    Voto voto = new Voto();
                    voto.votar();
                    VotoController votoController = new VotoController(voto, PATH_VOTO+voteButton.getName()+".txt");
                    votoController.escribirVotaciones();
                    

                    JOptionPane.showMessageDialog(frame, "Has votado por " + producto.getName());
                }
            });

            panel.add(label);
            panel.add(voteButton);
            mainPanel.add(panel);
        }

        frame.add(mainPanel);
        frame.setVisible(true);
    }




    // private static ArrayList<Voto> cargarVotacionesDesdeArchivo(ArrayList<Producto> productos, String archivo) {
    //     FileController fileController = new FileController(archivo);
    //     return fileController.leerVotaciones(productos);
    // }

    // private static Voto obtenerVotacion(Producto producto, ArrayList<Voto> votaciones) {
    //     for (Voto votacion : votaciones) {
    //         if (votacion.getProducto().getName().equals(producto.getName())) {
    //             return votacion;
    //         }
    //     }
    //     Voto nuevaVotacion = new Voto(producto);
    //     votaciones.add(nuevaVotacion);
    //     return nuevaVotacion;
    // }

    // private static void guardarVotacionesEnArchivo(ArrayList<Voto> votaciones, String archivo) {
    //     FileController fileController = new FileController(archivo);
    //     fileController.escribirVotaciones(null);
    // }
}
