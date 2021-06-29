package Principal;

import Ventanas.VentanaInicio;

public class Main {

    public static VentanaInicio inicio = new VentanaInicio();
    
    public static void main(String[] args) {
        
        //instanciamos        
        
        inicio.setVisible(true);// que se vea
        inicio.setResizable(false);// que no sea modificable su tamaño        
        inicio.CentrarPanel();

    }    
}
