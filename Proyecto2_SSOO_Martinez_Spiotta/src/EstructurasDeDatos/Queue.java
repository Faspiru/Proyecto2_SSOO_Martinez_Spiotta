package EstructurasDeDatos;

import Clases.Character;
import java.util.Arrays;
import java.util.Collections;

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
    
    public String converterToStringCartoon() {
        String cadena = "";
        if (this.esVacia()) {
            cadena += "Cola Vacia!";
        } else {
            Nodo aux = pFirst;
            while (aux != pLast) {
                cadena += aux.getElemento().getId() + " <-- ";
                aux = aux.getpNext();
            }
            cadena += aux.getElemento().getId();
        } 
        return cadena; //.substring(0, cadena.length()-5);
    }
    
    public String converterToStringNick() {
        String cadena = "";
        if (this.esVacia()) {
            cadena += "Cola Vacia!";
        } else {
            Nodo aux = pFirst;
            while (aux != pLast) {
                cadena += aux.getElemento().getId() + " <-- ";
                aux = aux.getpNext();
            }
            cadena += aux.getElemento().getId();
        } 
        
        String [] groups = cadena.split(" <-- ");
        Collections.reverse(Arrays.asList(groups));
        String resultado = String.join(" --> ", groups);
        return resultado; //.substring(0, cadena.length()-5);
    }
    
    public Nodo desencolarCharacter(String dato){  
        int times = 0;
        Nodo auxEliminado = null;
        Nodo aux = pFirst;
        int sizeM = getSize();
        int i = 0;
        
        while(i < sizeM){
            aux = pFirst;
            String eliminado = aux.getElemento().getId();
            desencolar();
            if (!eliminado.equals(dato)){
                encolar(aux.getElemento());
            } else if (times == 1){
                encolar(aux.getElemento());
            } else {
                times = 1;
                auxEliminado = aux;
                sizeM -= 1;
            }     
            i ++;
        }  
        
        return auxEliminado;
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
