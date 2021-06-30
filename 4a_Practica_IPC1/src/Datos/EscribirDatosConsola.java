
package Datos;

public class EscribirDatosConsola extends EscribirDatos {
    //private InterfazConsola interfaz = new InterfazConsola();
    private int tablero[] = new int[4];
    private int serpientes[][];
    private int numSerpientes;
    private int escaleras[][];
    private int numEscaleras;
    
    /**
     * Pide el comienzo y final del tablero validados
     */
    private void pedirDatosTablero() {
        
    }
    
    /**
     * Pide los datos por consola de las serpientes validados
     */
    private void pedirDatosSerpientes() {
        
    }
    
    /**
     * Pide los datos de las escaleras por consola validados
     */
    private void pedirDatosEscaleras() {
        
    }
    
    /**
     * Funcion publica que crea los datos desde la consola
     */
    public void crearDatos() {
        pedirDatosTablero();
        pedirDatosSerpientes();
        pedirDatosEscaleras();
        close();
    }
    
    /**
     * Crea los datos predeterminados definidos en esta funcion
     */
    public void crearDatosPredeterminados() {
        setPosicion(7,0,0,0); //Tablero
        setLinea();
        setPosicion(0,1,3,2); //Serpiente 1
        setSeparador();
        setPosicion(3,4,5,2);  //Serpiente 2
        setSeparador();
        setPosicion(6,7,7,1);  //Serpiente 3
        setLinea();
        setPosicion(3,0,0,7);  // Escalera 1
        setSeparador();
        setPosicion(5,4,3,1); // Escalera 2
        setSeparador();
        setPosicion(1,5,2,3); // Escalera 3
        close();
    }
}
