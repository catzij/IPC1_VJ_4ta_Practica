package Ventanas;

import Principal.Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Reportes implements ActionListener {
    
    private static JPanel PanelDerecho = new JPanel();
    
    private JButton Regresar ;
    
    //CONSTRUCTOR
    public Reportes(){
        
        // un panel a la derecha para colocar las accion del usario
        PanelDerecho.setLayout(null);// anular la ubicacion que da java
        PanelDerecho.setVisible(true);//visibilidad del panel
        PanelDerecho.setBackground(Color.LIGHT_GRAY);//color rojo
        PanelDerecho.setBounds(VentanaInicio.PANEL_MENU_REPORTE.getWidth()-440, 20, 400, 640);//posicion del panel
        VentanaInicio.PANEL_MENU_REPORTE.add(PanelDerecho);
        //fin panel derecho
        
        Regresar = new JButton();
        Regresar.setFont(new Font(("cooper black"),0,50));
        Regresar.setText("Regresar");
        Regresar.setBounds(10, 10, 380, 100);
        Regresar.addActionListener(this);
        PanelDerecho.add(Regresar);
        
    }//FIN CONSTRUCTOR
    
    
    private void Regresar() {        

        Main.inicio.setSize(VentanaInicio.PANEL_MENU_PRINCIPAL.getWidth(), VentanaInicio.PANEL_MENU_PRINCIPAL.getHeight());
        VentanaInicio.ImagenDeFondo.setBounds(0, 0, VentanaInicio.PANEL_MENU_PRINCIPAL.getWidth(), VentanaInicio.PANEL_MENU_PRINCIPAL.getHeight());
        VentanaInicio.ImagenDeFondo.setIcon(new ImageIcon(VentanaInicio.IMAGEN_DE_FONDO.getImage().getScaledInstance(VentanaInicio.ImagenDeFondo.getWidth(), VentanaInicio.ImagenDeFondo.getHeight(), Image.SCALE_SMOOTH)));
        VentanaInicio.PANEL_MENU_PRINCIPAL.add(VentanaInicio.ImagenDeFondo);
        Main.inicio.setLocationRelativeTo(null);        
        VentanaInicio.PANEL_MENU_PRINCIPAL.setVisible(true);        
        VentanaInicio.PANEL_MENU_REPORTE.setVisible(false);
        Main.inicio.setTitle("NO SE QUE PONER ACA");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == Regresar) {
            Regresar();
        }        
    }    
}