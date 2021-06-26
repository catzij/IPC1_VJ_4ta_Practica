package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame implements ActionListener {
    
    public static boolean INGRESAR_DATOS = true;
    
    //paneles
    public static JPanel PANEL_MENU_PRINCIPAL = new JPanel();
    public static JPanel PANEL_MENU_JUEGO = new JPanel();
    public static JPanel PANEL_MENU_DATOS = new JPanel();
    public static JPanel PANEL_MENU_CREAR = new JPanel();
    public static JPanel PANEL_MENU_REPORTE = new JPanel();
    
    public static JLabel ImagenDeFondo;   
    
   private final ImageIcon IMAGEN_DE_FONDO = new ImageIcon("imagenes/fondo_Principal.jpg");
   private final ImageIcon  TEXTURA_BOTON_SALIR = new ImageIcon("imagenes/exit.pnj");
   /*private final ImageIcon IMAGEN_DE_FONDO = new ImageIcon("imagenes/fondo_Principal.jpg");
   private final ImageIcon IMAGEN_DE_FONDO = new ImageIcon("imagenes/fondo_Principal.jpg");
   private final ImageIcon IMAGEN_DE_FONDO = new ImageIcon("imagenes/fondo_Principal.jpg");*/
   
    private JButton[] Botones = new JButton[3];
    public static JLabel ImagenDeFondo1;
    
    public VentanaInicio(){
        
        setTitle(" * SERPIENTES Y ESCALERAS *");
        setSize(480, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
            
        AsignarPanel();
        
        for (int i = 0; i < Botones.length; i++) {
            
            Botones[i] = new JButton();
            Botones[i].setBounds(100, 175 + (i * 125), 275, 75);
            String tmp = Seleccion(i);
            Botones[i].setText(tmp);
            PANEL_MENU_PRINCIPAL.add(Botones[i]);
            Botones[i].addActionListener(this);
        }
        
        
    }
    
    private void AsignarPanel() {            
        //mostrar menu principal
        PANEL_MENU_PRINCIPAL.setVisible(true);
        PANEL_MENU_PRINCIPAL.setBounds(0, 0, 4, 7);        
        PANEL_MENU_PRINCIPAL.setLayout(null);        
        this.getContentPane().add(PANEL_MENU_PRINCIPAL);//agregamos el panel a la ventana
        
        ImagenDeFondo1 = new JLabel();
        ImagenDeFondo1.setBounds(0,0, 480, 720);
        ImagenDeFondo1.setIcon(IMAGEN_DE_FONDO);        
        //getContentPane().add(ImagenDeFondo1);
        PANEL_MENU_PRINCIPAL.add(ImagenDeFondo1);
        
                
        /*PANEL_MENU_DATOS.setVisible(false);
        PANEL_MENU_DATOS.setBounds(0, 0, 350, 480);        
        PANEL_MENU_DATOS.setLayout(null);
        getContentPane().add(PANEL_MENU_DATOS);*/
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

            if (INGRESAR_DATOS) {
                setTitle("Menu Datos Personales");//desaparcer el dar nombre a la ventan
                setSize(PANEL_MENU_DATOS.getWidth(), PANEL_MENU_DATOS.getHeight());//desaparcer dar un nuevo tamañao
                //ImagenDeFondo.setBounds(0, 0, PANEL_MENU_DATOS.getWidth(), PANEL_MENU_DATOS.getHeight());// Cambiar las dimencionales del fondo
                //ImagenDeFondo.setIcon(new ImageIcon(IMAGEN_DE_FONDO_PANEL_DATOS.getImage().getScaledInstance(ImagenDeFondo.getWidth(), ImagenDeFondo.getHeight(), Image.SCALE_SMOOTH)));// Cambiar el fondo
                PANEL_MENU_DATOS.setVisible(true);// que se vea el panel
                PANEL_MENU_PRINCIPAL.setVisible(false);// que se vea el panel
            }else{
                
            setTitle("Granga de " );//desaparcer el dar nombre a la ventan
            setSize(PANEL_MENU_JUEGO.getWidth(), PANEL_MENU_JUEGO.getHeight());//desaparcer dar un nuevo tamañao
            PANEL_MENU_JUEGO.setVisible(true);// que se vea el panel
            PANEL_MENU_PRINCIPAL.setVisible(false);// que se vea el panel
            } 
        }        
         //boton 2. SALIR   
        if (e.getSource() == Botones[2]) {// boton salir
            System.exit(0);
        }
    }    
}
