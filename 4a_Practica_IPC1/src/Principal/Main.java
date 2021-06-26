/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Ventanas.VentanaInicio;

/**
 *
 * @author catzi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //instanciamos
        VentanaInicio inicio = new VentanaInicio();
        
        inicio.setVisible(true);// que se vea
        inicio.setResizable(false);// que no sea modificable su tamaño
        inicio.setLocationRelativeTo(null);//se ubica ene l centro

    }    
}
