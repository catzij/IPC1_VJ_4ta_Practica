
package Ventanas;

import Principal.Main;
import static Ventanas.VentanaInicio.IMAGEN_TABLERO;
import static Ventanas.VentanaInicio.ImagenDeFondo;
import static Ventanas.VentanaInicio.PANEL_MENU_JUEGO;
import static Ventanas.VentanaInicio.PANEL_MENU_PRINCIPAL;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AntesDeJugar implements ActionListener {
    
    
    private static JButton JUGAR;

    public AntesDeJugar(){        
        
        //BOTON
        JUGAR = new JButton();        
        JUGAR.setBounds(10, 10, 300, 100);
        JUGAR.setFont(new Font(("cooper black"),0,50));
        JUGAR.setText("JUGAR");
        JUGAR.addActionListener(this);
        VentanaInicio.PANEL_MENU_DATOS.add(JUGAR);
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
    }
}
