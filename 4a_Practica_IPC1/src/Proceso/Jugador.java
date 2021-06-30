package Proceso;

import Ventanas.Juego;
import javax.swing.JOptionPane;

public class Jugador extends Fichas{
    
    private String nombre;
    private int lugar;
    private int turno;
    private int tableroXI;
    private int tableroYI;
    private int tableroXF;
    private int tableroYF;
    private boolean PierdeTurno=false;
    private int instanciaJugador;
    
    Juego jugador;
    
    public Jugador(String nombre, int lugar, int posicionX, int posicionY, int tableroXF, int tableroYF) {
        this.nombre = nombre;
        this.posicionX = tableroXI = posicionX;
        this.posicionY = tableroYI = posicionY;
        this.lugar = lugar;
        this.turno = lugar;
        this.tableroXF = tableroXF;
        this.tableroYF = tableroYF;
        instanciaJugador++;
    }
    public Jugador(String nombre, int lugar ){
        this.lugar = lugar;
        this.nombre = nombre;
    }

    public int getLugar() {
        return lugar;
    }
    public int getInstanciaJugador() {
        return instanciaJugador;
    }
    
    private void PierdeTurno(int posicionX,int posicionY) {
        if (PierdeTurno) {
            JOptionPane.showMessageDialog(null, "El jugador "+getNombre()+" Pierde Turno");
        }
    }

    public int SaberXdeCuadros(int numero){        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (numero == jugador.controlNumeroCuadro[i][j]) {
                    return i;
                }                
            }
        }        
        return 0;
    }
    public int SaberYdeCuadros(int numero){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (numero == jugador.controlNumeroCuadro[i][j]) {
                    return j;
                }     
            }
        }        
        return 0;        
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getTurno() {
        return turno;
    }
    
    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void ganador() {
       if (lugar>=100) {
            JOptionPane.showMessageDialog(null, "El jugador "+getNombre()+" GANO !!!");
        }
    }
}
