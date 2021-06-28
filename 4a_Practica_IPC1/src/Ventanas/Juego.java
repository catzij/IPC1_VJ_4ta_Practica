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

    public static JTextField JUGADORES = new JTextField();//para mostrar el nombre y nickname               
    
    private static final ImageIcon DADO_CARA_1 = new ImageIcon("imagenes/DADOS_cara_1.png");
    private static final ImageIcon DADO_CARA_2 = new ImageIcon("imagenes/DADOS_cara_2.png");
    private static final ImageIcon DADO_CARA_3 = new ImageIcon("imagenes/DADOS_cara_3.png");
    private static final ImageIcon DADO_CARA_4 = new ImageIcon("imagenes/DADOS_cara_4.png");
    private static final ImageIcon DADO_CARA_5 = new ImageIcon("imagenes/DADOS_cara_5.png");
    private static final ImageIcon DADO_CARA_6 = new ImageIcon("imagenes/DADOS_cara_6.png");
    private static final ImageIcon FONDO_CUADRO_AMARILLO = new ImageIcon("imagenes/amarillo.jpg");
    private static final ImageIcon FONDO_CUADRO_CELESTE = new ImageIcon("imagenes/celeste.jpg");
    private static final ImageIcon FICHA1 = new ImageIcon("imagenes/FICHA1.png");
    private static final ImageIcon FICHA2 = new ImageIcon("imagenes/FICHA2.jpg");
    private static final ImageIcon FICHA3 = new ImageIcon("imagenes/FICHA3.jpg");
    private static final ImageIcon FICHA4 = new ImageIcon("imagenes/FICHA4.jpg");
    private static final ImageIcon FICHA5 = new ImageIcon("imagenes/FICHA5.jpg");
    private static final ImageIcon FICHA6 = new ImageIcon("imagenes/FICHA6.jpg");
    
    private static JLabel Imagen;
    private static JLabel DADO1;
    private static JLabel DADO2;

    private JButton Regresar;
    private JButton TirarDados;    
    
    private static JPanel PanelDerecho = new JPanel();
    private static JPanel TABLA = new JPanel();
    
    
    //CONSTRUCTOR
    public Juego(){
        
    JLabel[][] cuadro = new JLabel[10][10];
    JLabel[][] numeroCuadro = new JLabel[10][10];
    JLabel[][] fichaCuadro1 = new JLabel[10][10];
    JPanel[][] panel = new JPanel[10][10];    
                
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
        TABLA.setBackground(Color.WHITE);
        VentanaInicio.PANEL_MENU_JUEGO.add(TABLA);
        
        int numero = 0;
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro.length; j++){
            
                cuadro[i][j] = new JLabel();
                cuadro[i][j].setOpaque(true);
                cuadro[i][j].setBounds(5+(j*65),TABLA.getHeight()-60-(i*65),55,55);
                if (i%2==0) {
                    if (j%2==0) {
                        cuadro[i][j].setIcon(new ImageIcon(FONDO_CUADRO_AMARILLO.getImage().getScaledInstance(cuadro[i][j].getWidth(), cuadro[i][j].getHeight(), Image.SCALE_SMOOTH)));
                    }else{
                        cuadro[i][j].setIcon(new ImageIcon(FONDO_CUADRO_CELESTE.getImage().getScaledInstance(cuadro[i][j].getWidth(), cuadro[i][j].getHeight(), Image.SCALE_SMOOTH)));
                    }
                }else{
                    if (j%2==0) {
                        cuadro[i][j].setIcon(new ImageIcon(FONDO_CUADRO_CELESTE.getImage().getScaledInstance(cuadro[i][j].getWidth(), cuadro[i][j].getHeight(), Image.SCALE_SMOOTH)));
                    }else{
                        cuadro[i][j].setIcon(new ImageIcon(FONDO_CUADRO_AMARILLO.getImage().getScaledInstance(cuadro[i][j].getWidth(), cuadro[i][j].getHeight(), Image.SCALE_SMOOTH)));
                    }
                }
                TABLA.add(cuadro[i][j]);
                
                //agregado numeracion a los cuadro visual
                numeroCuadro[i][j] = new JLabel();
                //numeroCuadro[i][j].setOpaque(true);//que se pueda cabmiar el color de fondo
                //numeroCuadro[i][j].setBackground(Color.BLACK);//color fondo
                numero = NumeroCuadro(i,numero);
                numeroCuadro[i][j].setText(""+numero);
                numeroCuadro[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                numeroCuadro[i][j].setForeground(Color.BLACK);//color letra
                numeroCuadro[i][j].setBounds(cuadro[i][j].getWidth()-45,cuadro[i][j].getHeight()-30,25,10);//posicionX,posicionY,tamañoX,tamañoY
                numeroCuadro[i][j].setVisible(true);
                cuadro[i][j].add(numeroCuadro[i][j]);
            }   
        }
        
        fichaCuadro1[0][0] = new JLabel();
        fichaCuadro1[0][0].setBounds(0,0,20,20);
        fichaCuadro1[0][0].setIcon(new ImageIcon(FICHA1.getImage().getScaledInstance(fichaCuadro1[0][0].getWidth(), fichaCuadro1[0][0].getHeight(), Image.SCALE_SMOOTH)));
        cuadro[0][0].add(fichaCuadro1[0][0]);
        
        /*for (int i = 0; i < numeroCuadro.length; i++) {
            for (int j = 0; j < numeroCuadro.length; j++) {
                
                panel[i][j] = new JPanel();
                panel[i][j].setBounds(15+(j*65),TABLA.getHeight()-(i*70),25,10);
                panel[i][j].setLayout(null);
                panel[i][j].setVisible(true);
                cuadro[i][j].add(panel[i][j]);                                
                
                //TABLA.add(numeroCuadro[i][j]);
                //panel[i][j].add(numeroCuadro[i][j]);
            }
        }*/   
        
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
        TirarDados.setBounds(10,PanelDerecho.getHeight()-300,380,100);
        TirarDados.addActionListener(this);
        PanelDerecho.add(TirarDados);
        //fin botones
        
        //label dados
        DADO1 = new JLabel();
        //labelDados.setText("DADO 1");
        //labelDados.setFont(new Font(("cooper black"),0,50));
        DADO1.setBounds(0,PanelDerecho.getHeight()-200, 200, 200);
        //labelDados.setBackground(Color.red);
        //labelDados.setOpaque(true);        
        DADO1.setIcon(new ImageIcon(DADO_CARA_6.getImage().getScaledInstance(DADO1.getWidth(), DADO1.getHeight(), Image.SCALE_SMOOTH)));
        //labelDados.add(Imagen);
        PanelDerecho.add(DADO1);
        
        DADO2 = new JLabel();
        //labelDados1.setText("DADO 1");
        //labelDados1.setFont(new Font(("cooper black"),0,50));
        DADO2.setBounds(200,PanelDerecho.getHeight()-200, 200, 200);
        //labelDados1.setBackground(Color.GREEN);
        DADO2.setIcon(new ImageIcon(DADO_CARA_6.getImage().getScaledInstance(DADO2.getWidth(), DADO2.getHeight(), Image.SCALE_SMOOTH)));
        DADO2.setOpaque(true);
        PanelDerecho.add(DADO2);        
        
    }//FIN CONSTRUCTOR
    
    public void agregarColorTabla(){
    }
    
    public int NumeroCuadro(int fila, int valor){
        
        int numero = valor;
        if (fila%2==0) {//0,2,4,6,8,
            if (numero == 11 || numero == 31 || numero == 51 || numero == 71 || numero == 91){
                numero+=10;
            }else{
                    numero++;
            }
            
        }else{//1,3,5,7,9
            if (numero == 10 || numero == 30 || numero == 50 || numero == 70 || numero == 90){
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
        if (Presionar.getSource() == TirarDados) {
            DADO1.setIcon(new ImageIcon(seleccionDado().getImage().getScaledInstance(DADO1.getWidth(), DADO1.getHeight(), Image.SCALE_SMOOTH)));
            DADO2.setIcon(new ImageIcon(seleccionDado().getImage().getScaledInstance(DADO2.getWidth(), DADO2.getHeight(), Image.SCALE_SMOOTH)));            
        }
    }

    public ImageIcon seleccionDado(){
        int numero = (int)(Math.random()*6);
        
        switch(numero){
            case 0:
                return DADO_CARA_1;
            case 1:
                return DADO_CARA_2;
            case 2:
                return DADO_CARA_3;
            case 3:
                return DADO_CARA_4;
            case 4:
                return DADO_CARA_5;
            case 5:
                return DADO_CARA_6;
            default :
                return DADO_CARA_6;
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