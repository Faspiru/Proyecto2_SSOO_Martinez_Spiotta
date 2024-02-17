package EstructurasDeDatos;

/**
 *
 * @author fabriziospiotta
 */
public class Nodo{
    
    private Clases.Character elemento;
    private Nodo pNext;

    public Nodo(Clases.Character elemento, Nodo pNext) {
        this.elemento = elemento;
        this.pNext = pNext;
    }

    public Nodo(Clases.Character elemento) {
        this.elemento = elemento;
        this.pNext = null;
    }

    public Clases.Character getElemento() {
        return elemento;
    }

    public void setElemento(Clases.Character elemento) {
        this.elemento = elemento;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
        
}
