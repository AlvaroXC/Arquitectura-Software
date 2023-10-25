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

    /**
     * Creates new form VistaGraficas
     */
    public VistaGraficaBarras(ArrayList<Producto> productos) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.productos = productos;
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

    // public int MayorValor(int rojo, int verde, int azul){
    //     if(rojo>verde && rojo>azul){
    //         return rojo;
    //     }
    //     else if(verde>azul){
    //         return verde;
    //     }
    //     else{
    //         return azul;
    //     }
    // }

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
        // int largo_r = rojo*250/valMayor;
        // int largo_v = verde*250/valMayor;
        // int largo_a = azul*250/valMayor;

        int y=100;
        int y2 = 125;
        for (int i = 0; i < alturasBarras.length; i++) {
            Color color = generarColor();
            
            g.setColor(color);
            g.fillRect(100, y, alturasBarras[i], 40);
            g.drawString(productos.get(i).getName(), 20, y2);

            // coloresProductos.add(color);
            // g.setColor(color);
            // g.fillArc(40, 80, 200, 200, inicioAngulo, grados[i]);
            // g.fillRect(250, cuadro, 20, 20);
            // g.drawString(productos.get(i).getName(), 275, y);
            // inicioAngulo+=grados[i];
            // y+=30;
            // cuadro+=30;
            y+=50;
            y2+=50;
        }

        

        // g.setColor(new Color(255,0,0));
        // g.fillRect(100, 100, largo_r, 40);
        // g.drawString(productos.get(0).getName(), 20, 125);

        // g.setColor(new Color(0,130,0));
        // g.fillRect(100, 150, largo_v, 40);
        // g.drawString(productos.get(1).getName(), 20, 175);

        // g.setColor(new Color(0,0,255));
        // g.fillRect(100, 200, largo_a, 40);
        // g.drawString(productos.get(2).getName(), 20, 225);
    }

    public Color generarColor(){
        Random rand = new Random();
        int red = rand.nextInt(256); // Valor aleatorio entre 0 y 255 para el componente rojo
        int green = rand.nextInt(256); // Valor aleatorio entre 0 y 255 para el componente verde
        int blue = rand.nextInt(256); // Valor aleatorio entre 0 y 255 para el componente azul

        return new Color(red, green, blue);
    }
}
