
package Datos;

public abstract class DatosArchivo {
    
    protected String archivo;
    
    public DatosArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    /**
     * Confirma si el archivo existe.
     * 
     * @return boolean
     */    
    abstract public boolean existeArchivo();

    /**
     * Obtiene el nombre del archivo
     * @return 
     */
    public String getArchivo() {
        return archivo;
    }
    
}
