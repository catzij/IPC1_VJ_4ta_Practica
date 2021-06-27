package Ventanas;

import Principal.Main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Juego  implements ActionListener{
    
    public static int TiempoDelJuego[] = new int[]{0, 0, 0};// tiempo horas, minutos, segundo

    public static JTextField DatosNIckOror = new JTextField();//para mostrar el nombre y nickname        

    private JButton Regresar;
    private JButton TirarDados;    
    
    private static JPanel PanelDerecho = new JPanel();
    private static JPanel TABLA = new JPanel();
    
    private JLabel[][] cuadro = new JLabel[10][10];
    
    //CONSTRUCTOR
    public Juego(){
                
        // un panel a la derecha para colocar las accion del usario
        PanelDerecho.setLayout(null);// anular la ubicacion que da java
        PanelDerecho.setVisible(true);//visibilidad del panel
        PanelDerecho.setBackground(Color.LIGHT_GRAY);//color rojo
        PanelDerecho.setBounds(VentanaInicio.PANEL_MENU_JUEGO.getWidth()-440, 20, 400, 640);//posicion del panel
        VentanaInicio.PANEL_MENU_JUEGO.add(PanelDerecho);
        //fin panel derecho
        
        //tabla JUEGO
        TABLA.setLayout(null);
        TABLA.setVisible(true);
        TABLA.setBounds(80, 20, 650,650 );
        TABLA.setBackground(Color.DARK_GRAY);
        VentanaInicio.PANEL_MENU_JUEGO.add(TABLA);
        
        int numero = 0;        
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro.length; j++) {                
                
                numero = numeroFicha(i,numero);                
            
                cuadro[i][j] = new JLabel();
                cuadro[i][j].setOpaque(true);
                //cuadro[i][j].setText(i+"#"+j);
                cuadro[i][j].setText(""+numero);
                cuadro[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                cuadro[i][j].setForeground(Color.WHITE);//color letra
                cuadro[i][j].setBackground(Color.BLACK);//color fondo
                cuadro[i][j].setBounds(5+(j*65),TABLA.getHeight()-60-(i*65),55,55);
                TABLA.add(cuadro[i][j]);
            }
        }        
        //FIN TABLERO JUEGO
        
        //botones
            //BOTON REGRESAR AL MENU PRINCIPAL
        Regresar = new JButton();
        Regresar.setFont(new Font(("cooper black"),0,50));
        Regresar.setText("Regresar");
        Regresar.setBounds(10, 10, 380, 100);
        Regresar.addActionListener(this);
        PanelDerecho.add(Regresar);        
            //FIN BOTON REGRESAR
            //BOTON TIRAR DADOS
        TirarDados = new JButton();
        TirarDados.setText("Tirar Dados");
        TirarDados.setFont(new Font(("cooper black"),0,50));
        TirarDados.setBounds(10,110,380,100);
        TirarDados.addActionListener(this);
        PanelDerecho.add(TirarDados);
        
    }//FIN CONSTRUCTOR
    
    public int numeroFicha(int fila, int valor){
        
        int numero = valor;
        if (fila%2==0) {//0,2,4,6,8,
            if (numero == 11 || numero == 31 || numero == 51 || numero == 71 || numero == 91) {
                numero+=10;
            }else{
                    numero++;
            }
            
        }else{//1,3,5,7,9
            if (numero == 10 || numero == 30||numero == 50 || numero == 70 || numero == 90) {
            numero+=10;
            }else{
                numero--;
            }            
        }
        return numero;
    }

    @Override
    public void actionPerformed(ActionEvent Presionar) {        
        
        if (Presionar.getSource() == Regresar) {
            Regresar();
        }
    }
    
    private void Regresar() {

        Main.inicio.setSize(VentanaInicio.PANEL_MENU_PRINCIPAL.getWidth(), VentanaInicio.PANEL_MENU_PRINCIPAL.getHeight());
        VentanaInicio.ImagenDeFondo.setBounds(0, 0, VentanaInicio.PANEL_MENU_PRINCIPAL.getWidth(), VentanaInicio.PANEL_MENU_PRINCIPAL.getHeight());
        VentanaInicio.ImagenDeFondo.setIcon(new ImageIcon(VentanaInicio.IMAGEN_DE_FONDO.getImage().getScaledInstance(VentanaInicio.ImagenDeFondo.getWidth(), VentanaInicio.ImagenDeFondo.getHeight(), Image.SCALE_SMOOTH)));
        VentanaInicio.PANEL_MENU_PRINCIPAL.add(VentanaInicio.ImagenDeFondo);
        Main.inicio.setLocationRelativeTo(null);        
        VentanaInicio.PANEL_MENU_PRINCIPAL.setVisible(true);        
        VentanaInicio.PANEL_MENU_JUEGO.setVisible(false);
        Main.inicio.setTitle("NO SE QUE PONER ACA");
    }
}