package Ventanas;

import Principal.Main;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AntesDeJugar implements ActionListener {        
    
    private static JButton JUGAR;
    private static JButton JUGADOR;
    private int contador = 0;
    private int contadorMANDAR=contador;

    public int getContadorMANDAR() {
        return contadorMANDAR;
    }

    public AntesDeJugar(){
        
        //BOTON
        JUGAR = new JButton();        
        JUGAR.setBounds(40, 10, 400, 100);
        JUGAR.setFont(new Font(("cooper black"),0,50));
        JUGAR.setText("JUGAR");
        JUGAR.addActionListener(this);
        VentanaInicio.PANEL_MENU_DATOS.add(JUGAR);
        
        JUGADOR = new JButton();        
        JUGADOR.setBounds(40, 110, 400, 100);
        JUGADOR.setFont(new Font(("cooper black"),0,50));
        JUGADOR.setText("JUGADOR,NEW");
        JUGADOR.addActionListener(this);
        VentanaInicio.PANEL_MENU_DATOS.add(JUGADOR);              
        JUGAR.setEnabled(false);        
    }

    public int getContador() {
        return contador;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
                
        if (e.getSource() == JUGAR) {            
            
            Main.inicio.setSize(VentanaInicio.PANEL_MENU_JUEGO.getWidth(), VentanaInicio.PANEL_MENU_JUEGO.getHeight());                
            VentanaInicio.ImagenDeFondo.setBounds(0, 0, VentanaInicio.PANEL_MENU_JUEGO.getWidth(), VentanaInicio.PANEL_MENU_JUEGO.getHeight());
            VentanaInicio.ImagenDeFondo.setIcon(new ImageIcon(VentanaInicio.IMAGEN_TABLERO.getImage().getScaledInstance(VentanaInicio.ImagenDeFondo.getWidth(), VentanaInicio.ImagenDeFondo.getHeight(), Image.SCALE_SMOOTH)));
            VentanaInicio.PANEL_MENU_JUEGO.add(VentanaInicio.ImagenDeFondo);
            Main.inicio.setTitle(" ***  A JUGAR !!! ");
            VentanaInicio.PANEL_MENU_JUEGO.setVisible(true);
            VentanaInicio.PANEL_MENU_DATOS.setVisible(false);
            Main.inicio.setLocationRelativeTo(null);       
        }
        
        if (e.getSource() == JUGADOR) {
            if (contador >=2) {            
                JUGAR.setEnabled(true);            
            }else{
                JUGAR.setEnabled(false);
            }            
            contador++;
        }
    }
}
