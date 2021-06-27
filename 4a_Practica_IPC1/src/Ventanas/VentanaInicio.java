package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaInicio extends JFrame implements ActionListener {
    
    public static boolean INGRESAR_DATOS = true;
    
    //paneles
    static JPanel PANEL_MENU_PRINCIPAL = new JPanel();
    static JPanel PANEL_MENU_JUEGO = new JPanel();
    private static JPanel PANEL_MENU_DATOS = new JPanel();
    static JPanel PANEL_MENU_REPORTE = new JPanel();
    
    public static JLabel ImagenDeFondo;
    
    public static final ImageIcon IMAGEN_DE_FONDO = new ImageIcon("imagenes/fondo_Principal.jpg");
    public static final ImageIcon IMAGEN_TABLERO = new ImageIcon("imagenes/fondoTablero.jpg");
   
    private JButton[] Botones = new JButton[3];
    
    //CONSTRUCTOR    
    public VentanaInicio(){
        
        setTitle(" * SERPIENTES Y ESCALERAS *");
        setSize(480, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
            
        AsignarPanel();
        
        for (int i = 0; i < Botones.length; i++) {
            
            Botones[i] = new JButton();
            Botones[i].setBounds(100, 250 + (i * 125), 275, 75);
            String tmp = Seleccion(i);
            Botones[i].setFont(new Font(("cooper black"),0,50));
            Botones[i].setText(tmp);
            PANEL_MENU_PRINCIPAL.add(Botones[i]);
            Botones[i].addActionListener(this);
        }
    }//FIN CONSTRUCTOR
    
    private void AsignarPanel() {       
        
        //BIENVENIDA
        JLabel BIENVENIDA = new JLabel();
        BIENVENIDA.setFont(new Font(("cooper black"),0,50));
        BIENVENIDA.setText("SERPIENTES Y");
        BIENVENIDA.setBounds(40, 40, 400, 75);
        BIENVENIDA.setForeground(Color.WHITE);
        BIENVENIDA.setHorizontalAlignment(SwingConstants.CENTER);// central el tesxto del booton
        PANEL_MENU_PRINCIPAL.add(BIENVENIDA);
        JLabel BIENVENIDA2 = new JLabel();
        BIENVENIDA2.setFont(new Font(("cooper black"),0,50));
        BIENVENIDA2.setText("ESCALERAS");
        BIENVENIDA2.setBounds(40, 40+80, 400, 75);
        BIENVENIDA2.setForeground(Color.WHITE);
        BIENVENIDA2.setHorizontalAlignment(SwingConstants.CENTER);// central el tesxto del booton
        PANEL_MENU_PRINCIPAL.add(BIENVENIDA2);
        //FIN BIENVENIDA
        
        //mostrar menu principal
        PANEL_MENU_PRINCIPAL.setVisible(true);
        PANEL_MENU_PRINCIPAL.setBounds(0, 0, 480, 720);
        PANEL_MENU_PRINCIPAL.setLayout(null);
        this.getContentPane().add(PANEL_MENU_PRINCIPAL);//agregamos el panel a la ventana        
        ImagenDeFondo = new JLabel();
        ImagenDeFondo.setBounds(0,0, PANEL_MENU_PRINCIPAL.getWidth(), PANEL_MENU_PRINCIPAL.getHeight());
        ImagenDeFondo.setIcon(IMAGEN_DE_FONDO);
        PANEL_MENU_PRINCIPAL.add(ImagenDeFondo);
        //FIN MOSTRAR MENU PRINCIPAL
                
        //MOSTRAR JUEGO INICIO
        PANEL_MENU_JUEGO.setVisible(false);
        PANEL_MENU_JUEGO.setBounds(0, 0, 1280, 720);
        PANEL_MENU_JUEGO.setLayout(null);
        getContentPane().add(PANEL_MENU_JUEGO);        
        
        Juego juego = new Juego();
        //FIN MOSTRAR JUEGO
        
        //MOSTRAR REPORTE
        PANEL_MENU_REPORTE.setVisible(false);
        PANEL_MENU_REPORTE.setBounds(0, 0, 1280, 720);
        PANEL_MENU_REPORTE.setLayout(null);
        getContentPane().add(PANEL_MENU_REPORTE);
        
        Reportes reporte = new Reportes();
        //FIN MOSTRAR REPORTE
    }

    private String Seleccion(int Selcionar) {
        switch (Selcionar) {
            case 0:
                return "Jugar";
            case 1:
                return "Reportes";
            case 2:
                return "Salir";
            default:
                return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton 0. JUGAR 
        if (e.getSource() == Botones[0]) {            
            
            setTitle("*** JUGAR ***");//desaparcer el dar nombre a la ventan
            setSize(PANEL_MENU_JUEGO.getWidth(), PANEL_MENU_JUEGO.getHeight());//desaparcer dar un nuevo tamañao
            setLocationRelativeTo(null);
            ImagenDeFondo.setBounds(0, 0, PANEL_MENU_JUEGO.getWidth(), PANEL_MENU_JUEGO.getHeight());// Cambiar las dimencionales del fondo
            ImagenDeFondo.setIcon(new ImageIcon(IMAGEN_TABLERO.getImage().getScaledInstance(ImagenDeFondo.getWidth(), ImagenDeFondo.getHeight(), Image.SCALE_SMOOTH)));// Cambiar el fondo            
            PANEL_MENU_JUEGO.add(ImagenDeFondo);
            PANEL_MENU_JUEGO.setVisible(true);// que se vea el panel
            PANEL_MENU_PRINCIPAL.setVisible(false);// que NO se vea el panel
            
        }
        if (e.getSource()== Botones[1] ) {
            
            setTitle("*** REPORTES ***");//desaparcer el dar nombre a la ventan
            setSize(PANEL_MENU_REPORTE.getWidth(), PANEL_MENU_REPORTE.getHeight());//desaparcer dar un nuevo tamañao
            setLocationRelativeTo(null);
            ImagenDeFondo.setBounds(0, 0, PANEL_MENU_REPORTE.getWidth(), PANEL_MENU_REPORTE.getHeight());// Cambiar las dimencionales del fondo
            ImagenDeFondo.setIcon(new ImageIcon(IMAGEN_TABLERO.getImage().getScaledInstance(ImagenDeFondo.getWidth(), ImagenDeFondo.getHeight(), Image.SCALE_SMOOTH)));// Cambiar el fondo            
            PANEL_MENU_REPORTE.add(ImagenDeFondo);
            PANEL_MENU_REPORTE.setVisible(true);// que se vea el panel
            PANEL_MENU_PRINCIPAL.setVisible(false);// que NO se vea el panel
            
        }
         //boton 2. SALIR   
        if (e.getSource() == Botones[2]) {// boton salir
            System.exit(0);
        }
    }    
}