package com.uady.mvcvotaciones.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import com.uady.mvcvotaciones.controller.VotoController;
import com.uady.mvcvotaciones.model.Producto;

/**
 * @author aitor
 */
public class VistaGraficaBarras extends javax.swing.JFrame {
    private javax.swing.JLabel Titulo;
    public ArrayList<Producto> productos;
    public ArrayList<Color> coloresProductos;

    /**
     * Creates new form VistaGraficas
     */
    public VistaGraficaBarras(ArrayList<Producto> productos, ArrayList<Color> coloresProductos) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.productos = productos;
        this.coloresProductos = coloresProductos;
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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

    public int determinarMayorVotacion(ArrayList<Integer> votosIndividuales){
        int maximo=0;
        for (int votaciones: votosIndividuales) {
            if(votaciones>maximo){
                maximo=votaciones;
            }
        }
        return maximo;
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        ArrayList<Integer> votosIndivuales = new ArrayList<>();
        for(Producto producto: productos){
            VotoController votoController = new VotoController(VistaVotaciones.PATH_VOTO+producto.getName()+".txt");
            int votoFrutaIndividual = votoController.obtenerTotalVotaciones();
            votosIndivuales.add(votoFrutaIndividual);
        }   
        
        int valMayor = determinarMayorVotacion(votosIndivuales);
        
        int []alturasBarras= new int [votosIndivuales.size()];
        for (int i = 0; i <votosIndivuales.size(); i++) {
            alturasBarras[i] = votosIndivuales.get(i)*250/valMayor;
        }

        int y=100;
        int y2 = 125;
        for (int i = 0; i < alturasBarras.length; i++) {
            g.setColor(coloresProductos.get(i));
            g.fillRect(100, y, alturasBarras[i], 40);
            g.drawString(productos.get(i).getName(), 20, y2);

            y+=50;
            y2+=50;
        }
    }
}
