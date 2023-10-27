package com.uady.mvcvotaciones.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.uady.mvcvotaciones.controller.VotoController;
import com.uady.mvcvotaciones.model.Producto;

public class VistaGraficaCircular extends javax.swing.JFrame {

    private javax.swing.JLabel Titulo;
    private ArrayList<Producto> productos;
    private ArrayList<Color> coloresProductos;

    public VistaGraficaCircular(ArrayList<Producto> productos, ArrayList<Color> coloresProductos) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.productos = productos;
        this.coloresProductos = coloresProductos;
        repaint();
    }

    private void initComponents() {

        Titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Votaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        pack();
    }

    public void paint(Graphics g){
        super.paint(g);

        int totalVotos=0;
        ArrayList<Integer> votosIndivuales = new ArrayList<>();
        VistaVotaciones vista = new VistaVotaciones();
        
        for(Producto producto: productos){
            VotoController votoController = new VotoController(vista.PATH_VOTO+producto.getName()+".txt");
            int votoFrutaIndividual = votoController.obtenerTotalVotaciones();
            votosIndivuales.add(votoFrutaIndividual);
            totalVotos+=votoFrutaIndividual;
        }

        int []grados= calcularGrados(votosIndivuales, totalVotos);
        
        int inicioAngulo=0;
        int y=135;
        int cuadro= 120;
        
        for (int i = 0; i < grados.length; i++) {
            g.setColor(coloresProductos.get(i));
            g.fillArc(40, 80, 200, 200, inicioAngulo, grados[i]);
            g.fillRect(250, cuadro, 20, 20);
            g.drawString(productos.get(i).getName(), 275, y);
            inicioAngulo+=grados[i];
            y+=30;
            cuadro+=30;
        }        
    }

    public int[] calcularGrados(ArrayList<Integer> votosIndivuales, int totalVotos){
        int grados[]= new int[votosIndivuales.size()];
        for (int i = 0; i <votosIndivuales.size(); i++) {
            grados[i] = votosIndivuales.get(i)*360/totalVotos;
        }

        return grados;
    }
}
