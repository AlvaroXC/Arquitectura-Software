package com.uady.mvcvotaciones.view;

import com.uady.mvcvotaciones.controller.ProductoController;
import com.uady.mvcvotaciones.controller.VotoController;
import com.uady.mvcvotaciones.model.Producto;
import com.uady.mvcvotaciones.model.Voto;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaVotaciones {

    public String PATH_VOTO= "src/main/resources/votaciones_";
    public Boolean bandera = false;

    public VistaVotaciones(){}

    public void initComponents(){
        // Carga la lista de productos desde el archivo productos.txt
        ProductoController productoController = new ProductoController();
        ArrayList<Producto> productos = productoController.cargarProductosDesdeArchivo();
        
        ArrayList<Color> coloresProductos = new ArrayList<>();
        for (int i=0; i<productos.size(); i++) {
            Random rand = new Random();
            int red = rand.nextInt(256); // Valor aleatorio entre 0 y 255 para el componente rojo
            int green = rand.nextInt(256); // Valor aleatorio entre 0 y 255 para el componente verde
            int blue = rand.nextInt(256);
            coloresProductos.add(new Color(red, green, blue));
        }
        VistaGraficaBarras barras = new VistaGraficaBarras(productos, coloresProductos);
        VistaGraficaCircular circular = new VistaGraficaCircular(productos, coloresProductos);

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
            JButton voteButton = new JButton("Votar por "+ producto.getName());
            voteButton.setName(producto.getName().toLowerCase());

            voteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Voto voto = new Voto();
                    VotoController votoController = new VotoController(voto, PATH_VOTO+voteButton.getName()+".txt");
                    votoController.escribirVotaciones();
                    if(bandera == true){
                        barras.repaint();
                        circular.repaint();
                    }
                }
            });

            panel.add(label);
            panel.add(voteButton);
            mainPanel.add(panel);
        }

        JPanel g_panel = new JPanel();
        g_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton graphsButton = new JButton("Ver gráficas");
        graphsButton.setName("graphsButton");
        graphsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barras.setVisible(true);
                circular.setVisible(true);
                bandera = true;
            }
        });

        g_panel.add(graphsButton);
        mainPanel.add(g_panel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}