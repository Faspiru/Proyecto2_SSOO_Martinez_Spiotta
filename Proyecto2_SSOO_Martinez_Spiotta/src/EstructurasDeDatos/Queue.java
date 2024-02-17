package EstructurasDeDatos;

import Clases.Character;

/**
 *
 * @author fabriziospiotta
 */
public class Queue {
    
    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    

    public Queue(){
        pFirst = null;
        pLast = null;
        size = 0;
    }

    public boolean esVacia() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    

    public void destructor() {
        while(pFirst!= null) {
            pFirst = pFirst.getpNext();
        }
    }

    public void encolar(Character valor) {
        Nodo pNew = new Nodo(valor);
        if (pFirst == null) {
            pFirst = pNew;
        } else {
            pLast.setpNext(pNew);
        }
        pLast = pNew;
        size ++; 
    }
    
    public void desencolar() {
        pFirst = pFirst.getpNext();
        size --;
        if (pFirst == null) {
            pLast = null;
        }
    }
    
    public Character leerCabeza() {
        return pFirst.getElemento();
    }
    
    public Character poll(){
        Character element = pFirst.getElemento();
        this.desencolar();
        return element;
    }
    
    public String converterToString() {
        String cadena = "";
        Nodo aux = pFirst;
        while (aux != null) {
            cadena += aux.getElemento().getId() + " --> ";
            aux = aux.getpNext();
        }
        return cadena.substring(0, cadena.length()-5);
    }

    public Nodo getpFirst() {
        return pFirst;
    }
    
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
