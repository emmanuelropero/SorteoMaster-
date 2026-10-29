
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sorteomaster;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelCarrera extends JPanel{
    private int[] posiciones = {65, 65, 65, 65};
    private String[] nombresGrupos = {"GRUPO 1", "GRUPO 2", "GRUPO 3", "GRUPO 4"};
    private int ultimoCarrito = -1;
    private Runnable accionAlTerminar;
    public PanelCarrera() {
        setBackground(new Color(25, 40, 61));
        
    }public void iniciarCarrera() {
        ultimoCarrito = -1;

   
    for (int i = 0; i < posiciones.length; i++) {
        posiciones[i] = 65;
    }

    
    javax.swing.Timer timer = new javax.swing.Timer(100, e -> {

        int meta = getWidth() - 80;
boolean todosLlegaron = true;

for (int i = 0; i < posiciones.length; i++) {

    
    if (posiciones[i] < meta) {

        int avance = 2 + (int) (Math.random() * 8);

        posiciones[i] += avance;

        
        if (posiciones[i] >= meta) {
            posiciones[i] = meta;
        if (posiciones[i] >= meta) {
    ultimoCarrito = i;
}
        }
    }

    
    if (posiciones[i] < meta) {
        todosLlegaron = false;
    }
}


if (todosLlegaron) {
    ((javax.swing.Timer) e.getSource()).stop();

    System.out.println("Carrera terminada");
    System.out.println("Último carrito: " + (ultimoCarrito + 1));

    if (accionAlTerminar != null) {
        accionAlTerminar.run();
    }
}
        

        
        repaint();
    });

    timer.start();
}
    public int obtenerUltimoCarrito() {
    return ultimoCarrito;
}
    public void avisarFinCarrera(Runnable accion) {
    this.accionAlTerminar = accion;
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int ancho = getWidth();
        int alto = getHeight();

int separacion = Math.max(1, (alto - 20) / Math.max(1, posiciones.length));
int altoCarril = Math.max(1, separacion - 2);
int altoCarrito = Math.max(6, Math.min(22, altoCarril - 8));

      
      for (int i = 0; i < posiciones.length; i++) {

           int y = 20 + (i * separacion);
           


           
            g.setColor(new Color(45, 65, 90));
            g.fillRoundRect(20, y, ancho - 40, altoCarril, 10, 10);
            
                       if (i < nombresGrupos.length) {
    
g.setColor(Color.WHITE);
int tamLetra = Math.max(8, Math.min(12, altoCarril - 4));
g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, tamLetra));
g.drawString(nombresGrupos[i], 70, y + Math.max(10, altoCarril / 2));
}

            
            g.setColor(Color.WHITE);
            g.drawLine(55, y, 55, y + altoCarril);

       
            g.setColor(Color.YELLOW);
            g.fillRect(ancho - 75, y, 5, altoCarril);
            
            
             
            int x = posiciones[i];

            
            g.setColor(Color.RED);
            g.fillRoundRect(x, y + (altoCarril - altoCarrito) / 2, 45, altoCarrito, 8, 8);

            
            g.setColor(Color.CYAN);
            g.fillRect(x + 15, y + (altoCarril - altoCarrito) / 2 + 3, 15, Math.max(3, altoCarrito / 3));

            
            g.setColor(Color.BLACK);
            int yRuedas = y + (altoCarril - altoCarrito) / 2 + altoCarrito - 4;
int tamRueda = Math.max(4, Math.min(10, altoCarrito / 2));

g.fillOval(x + 7, yRuedas, tamRueda, tamRueda);
g.fillOval(x + 31, yRuedas, tamRueda, tamRueda);
        }
    }
    
    

public void establecerGrupos(String[] grupos) {
    nombresGrupos = grupos;

    posiciones = new int[grupos.length];

    for (int i = 0; i < posiciones.length; i++) {
        posiciones[i] = 65;
    }

    repaint();
}
}
    
    

