package Ventanas;

import Proceso.*;
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
    private static final ImageIcon FICHA2 = new ImageIcon("imagenes/FICHA2.png");
    private static final ImageIcon FICHA3 = new ImageIcon("imagenes/FICHA3.png");
    private static final ImageIcon FICHA4 = new ImageIcon("imagenes/FICHA4.png");
    private static final ImageIcon FICHA5 = new ImageIcon("imagenes/FICHA5.png");
    private static final ImageIcon FICHA6 = new ImageIcon("imagenes/FICHA6.png");
        
    private static JLabel DADO1;
    private static JLabel DADO2;

    private JButton Regresar;
    private JButton TirarDados;    
    
    private static JPanel PanelDerecho = new JPanel();
    public static JPanel TABLA = new JPanel();
    
    protected JLabel[][] cuadro = new JLabel[10][10];
    JLabel[][] numeroCuadro = new JLabel[10][10]; 
    public int[][] controlNumeroCuadro = new int[10][10];
    
    JLabel fichaCuadro1; 
    JLabel fichaCuadro2; 
    JLabel fichaCuadro3; 
    JLabel fichaCuadro4; 
    JLabel fichaCuadro5; 
    JLabel fichaCuadro6; 
    
    JPanel[][] panel = new JPanel[10][10];
    
    private int turnoJugador = 1;    
    int contador1 = 1;
    int contador2 = 1;
    int contador3 = 1;
    int contador4 = 1;
    int contador5 = 1;
    int contador6 = 1;
    int suma2Dados = 0;
    int sumaDados = 0;
    
    private Jugador JUGADOR;
//  private AntesDeJugar Njugador;    
    private int jugadores=5;
    private Jugador[] newJugador = new Jugador[jugadores];
    //private newJugador = new Jugador[jugadores];
    //CONSTRUCTOR*************************************************************************
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
        TABLA.setBackground(Color.WHITE);
        VentanaInicio.PANEL_MENU_JUEGO.add(TABLA);
        
        agregarCuadros();        
        inicialVisual();        
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
        DADO1.setBounds(0,PanelDerecho.getHeight()-200, 200, 200);
        DADO1.setIcon(new ImageIcon(DADO_CARA_6.getImage().getScaledInstance(DADO1.getWidth(), DADO1.getHeight(), Image.SCALE_SMOOTH)));
        PanelDerecho.add(DADO1);
        
        DADO2 = new JLabel();
        DADO2.setBounds(200,PanelDerecho.getHeight()-200, 200, 200);        
        DADO2.setIcon(new ImageIcon(DADO_CARA_6.getImage().getScaledInstance(DADO2.getWidth(), DADO2.getHeight(), Image.SCALE_SMOOTH)));        
        PanelDerecho.add(DADO2);
        
    }//FIN CONSTRUCTOR
    
    public void NuevoJugador(){        
        //jugadores = Njugador.getContadorMANDAR();
        for (int i = 0; i < newJugador.length; i++) {
            newJugador[i] = new Jugador("JUGADOR ["+JUGADOR.getInstanciaJugador()+"]",1);
        }
    }    
    
    public void agregarCuadros(){
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
                numero = NumeroCuadro(i,numero);
                controlNumeroCuadro[i][j] = numero;                        
                numeroCuadro[i][j].setText(""+numero);
                numeroCuadro[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                numeroCuadro[i][j].setForeground(Color.BLACK);//color letra
                numeroCuadro[i][j].setBounds(cuadro[i][j].getWidth()-45,cuadro[i][j].getHeight()-30,25,10);//posicionX,posicionY,tamañoX,tamañoY
                numeroCuadro[i][j].setVisible(true);
                cuadro[i][j].add(numeroCuadro[i][j]);
            }
        }
    }
    
    public void inicialVisual(){
        fichaCuadro1 = new JLabel();
        fichaCuadro1.setBounds(0,0,19,19);
        fichaCuadro1.setIcon(new ImageIcon(FICHA1.getImage().getScaledInstance(fichaCuadro1.getWidth(), fichaCuadro1.getHeight(), Image.SCALE_SMOOTH)));
        cuadro[0][0].add(fichaCuadro1);
        
        fichaCuadro2 = new JLabel();
        fichaCuadro2.setBounds(18,0,19,19);
        fichaCuadro2.setIcon(new ImageIcon(FICHA2.getImage().getScaledInstance(fichaCuadro2.getWidth(), fichaCuadro2.getHeight(), Image.SCALE_SMOOTH)));
        cuadro[0][0].add(fichaCuadro2);
                
        fichaCuadro3 = new JLabel();
        fichaCuadro3.setBounds(36,0,19,19);
        fichaCuadro3.setIcon(new ImageIcon(FICHA3.getImage().getScaledInstance(fichaCuadro3.getWidth(), fichaCuadro3.getHeight(), Image.SCALE_SMOOTH)));
        cuadro[0][0].add(fichaCuadro3);
                
        fichaCuadro4 = new JLabel();
        fichaCuadro4.setBounds(0,36,19,19);
        fichaCuadro4.setIcon(new ImageIcon(FICHA4.getImage().getScaledInstance(fichaCuadro4.getWidth(), fichaCuadro4.getHeight(), Image.SCALE_SMOOTH)));
        cuadro[0][0].add(fichaCuadro4);
                
        fichaCuadro5 = new JLabel();
        fichaCuadro5.setBounds(18,36,19,19);
        fichaCuadro5.setIcon(new ImageIcon(FICHA5.getImage().getScaledInstance(fichaCuadro5.getWidth(), fichaCuadro5.getHeight(), Image.SCALE_SMOOTH)));
        cuadro[0][0].add(fichaCuadro5);
             
        fichaCuadro6 = new JLabel();
        fichaCuadro6.setBounds(36,36,19,19);
        fichaCuadro6.setIcon(new ImageIcon(FICHA6.getImage().getScaledInstance(fichaCuadro6.getWidth(), fichaCuadro6.getHeight(), Image.SCALE_SMOOTH)));
        cuadro[0][0].add(fichaCuadro6);
    }
    
    public void FICHASvisual(int turno, int moverX, int moverY){
        
        switch(turno){
            case 1:        
                fichaCuadro1 = new JLabel();
                fichaCuadro1.setBounds(0,0,19,19);
                fichaCuadro1.setIcon(new ImageIcon(FICHA1.getImage().getScaledInstance(fichaCuadro1.getWidth(), fichaCuadro1.getHeight(), Image.SCALE_SMOOTH)));                
                cuadro[1][1].add(fichaCuadro1);
                
                break;
            case 2:
                fichaCuadro2 = new JLabel();
                fichaCuadro2.setBounds(18,0,19,19);
                fichaCuadro2.setIcon(new ImageIcon(FICHA2.getImage().getScaledInstance(fichaCuadro1.getWidth(), fichaCuadro1.getHeight(), Image.SCALE_SMOOTH)));
                cuadro[2][2].add(fichaCuadro2);
                break;
            case 3:
                fichaCuadro3 = new JLabel();
                fichaCuadro3.setBounds(36,0,19,19);
                fichaCuadro3.setIcon(new ImageIcon(FICHA3.getImage().getScaledInstance(fichaCuadro1.getWidth(), fichaCuadro1.getHeight(), Image.SCALE_SMOOTH)));
                cuadro[moverX][moverY].add(fichaCuadro3);
                break;
            case 4:
                fichaCuadro4 = new JLabel();
                fichaCuadro4.setBounds(0,36,19,19);
                fichaCuadro4.setIcon(new ImageIcon(FICHA4.getImage().getScaledInstance(fichaCuadro1.getWidth(), fichaCuadro1.getHeight(), Image.SCALE_SMOOTH)));
                cuadro[moverX][moverY].add(fichaCuadro4);
                break;
            case 5:
                fichaCuadro5 = new JLabel();
                fichaCuadro5.setBounds(18,36,19,19);
                fichaCuadro5.setIcon(new ImageIcon(FICHA5.getImage().getScaledInstance(fichaCuadro1.getWidth(), fichaCuadro1.getHeight(), Image.SCALE_SMOOTH)));
                cuadro[moverX][moverY].add(fichaCuadro5);
                break;
            case 6:
                fichaCuadro6 = new JLabel();
                fichaCuadro6.setBounds(36,36,19,19);
                fichaCuadro6.setIcon(new ImageIcon(FICHA6.getImage().getScaledInstance(fichaCuadro1.getWidth(), fichaCuadro1.getHeight(), Image.SCALE_SMOOTH)));
                cuadro[moverX][moverY].add(fichaCuadro6);
                break;            
        }        
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
    public int SaberXdeCuadros(int numero){        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (numero == controlNumeroCuadro[i][j]) {
                    return j;
                }                
            }
        }        
        return 0;
    }
    public int SaberYdeCuadros(int numero){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (numero == controlNumeroCuadro[i][j]) {
                    return i;
                }     
            }
        }                
        return 0;
    }
    int dosveces=1;
    public void JUGAR(){
        
        
        switch (turnoJugador){
            case 1:
                contador1 = sumaDados + contador1;
                FICHASvisual(turnoJugador, SaberXdeCuadros(contador1), SaberYdeCuadros(contador1));                
                break;
            case 2:
                contador2 = sumaDados + contador2;
                FICHASvisual(turnoJugador, SaberXdeCuadros(contador2), SaberYdeCuadros(contador2));
                break;
            case 3:
                contador3 = sumaDados + contador3;
                FICHASvisual(turnoJugador, SaberXdeCuadros(contador3), SaberYdeCuadros(contador3));
                break;
            case 4:
                contador4 = sumaDados + contador4;
                FICHASvisual(turnoJugador, SaberXdeCuadros(contador4), SaberYdeCuadros(contador4));
                break;
            case 5:
                contador5 = sumaDados + contador5;
                FICHASvisual(turnoJugador, SaberXdeCuadros(contador5), SaberYdeCuadros(contador5));
                break;
            case 6:
                contador6 = sumaDados + contador6;
                FICHASvisual(turnoJugador, SaberXdeCuadros(contador6), SaberYdeCuadros(contador6));
                break;
            default :
                contador6 = sumaDados + contador6;
                FICHASvisual(turnoJugador, SaberXdeCuadros(contador6), SaberYdeCuadros(contador6));
                break;
        }
        if (turnoJugador == 6) {
             turnoJugador=0;
        }
        turnoJugador++;
    }

    @Override
    public void actionPerformed(ActionEvent Presionar) {
        
        if (Presionar.getSource() == Regresar) {
            Regresar();
        }
        if (Presionar.getSource() == TirarDados) {

            DADO1.setIcon(new ImageIcon(seleccionDado().getImage().getScaledInstance(DADO1.getWidth(), DADO1.getHeight(), Image.SCALE_SMOOTH)));
            DADO2.setIcon(new ImageIcon(seleccionDado().getImage().getScaledInstance(DADO2.getWidth(), DADO2.getHeight(), Image.SCALE_SMOOTH)));
            
            sumaDados = suma2Dados;
            JUGAR();            
            suma2Dados = 0;
        }
    }

    public ImageIcon seleccionDado(){
        int numero = (int)(Math.random()*6);
        //System.out.println(""+suma2Dados);
        suma2Dados = suma2Dados + numero + 1;
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
        Main.inicio.setTitle(" *** REGRESAMOS ***");
    }
}