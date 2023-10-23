package com.uady.mvcvotaciones.view;

import com.uady.mvcvotaciones.controller.ProductoController;
import com.uady.mvcvotaciones.controller.VotoController;
import com.uady.mvcvotaciones.model.Producto;
import com.uady.mvcvotaciones.model.Voto;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

        // for(Producto producto: productos){
        //     VotoController votoController = new VotoController(PATH_VOTO+producto.getName()+"txt");
        //     votoController.obtenerTotalVotaciones();
        // }


        JFrame frame = new JFrame("Votación de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

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


}
