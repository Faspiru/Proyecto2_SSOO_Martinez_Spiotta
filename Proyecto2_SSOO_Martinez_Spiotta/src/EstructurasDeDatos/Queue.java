/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author fabriziospiotta
 */
public class Queue<T> {
    
    private Nodo<T> pFirst;
    private Nodo<T> pLast;
    private int size;
    
    /**
     * Constructor de la clase cola
     */
    public Queue(){
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    /**
     * Método que indica si la cola está vacía
     * @return 
     */
    public boolean esVacia() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Método que destruye la cola
     */
    public void destructor() {
        while(pFirst!= null) {
            pFirst = pFirst.getpNext();
        }
    }
    
    /**
     * Método para encolar un valor en la cola
     * @param valor valor para ser encolado
     */
    public void encolar(T valor) {
        Nodo<T> pNew = new Nodo(valor);
        if (pFirst == null) {
            pFirst = pNew;
        } else {
            pLast.setpNext(pNew);
        }
        pLast = pNew;
        size ++; 
    }
    
    /**
     * Método que desencola el primer valor de la cola
     */
    public void desencolar() {
        pFirst = pFirst.getpNext();
        size --;
        if (pFirst == null) {
            pLast = null;
        }
    }
    
    /**
     * Método que devuelve el valor del primer nodo de la cola
     * @return elemento de pFirst de la cola
     */
    public T leerCabeza() {
        return pFirst.getElemento();
    }
    
    public T poll(){
        T element = pFirst.getElemento();
        this.desencolar();
        return element;
    }
    
    public String converterToString() {
        String cadena = "";
        Nodo aux = pFirst;
        while (aux != pLast) {
            cadena += aux.getElemento() + " --> ";
            aux = aux.getpNext();
        }
        cadena += aux.getElemento();
        return cadena;
    }
    
    /**
     * Método que devuelve el primer nodo de la cola
     * @return pFirst de la cola
     */
    public Nodo<T> getpFirst() {
        return pFirst;
    }

    /**
     * Método que asigna el primer nodo de la cola
     * @param pFirst el pfirst a ser asignado
     */
    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Método que devuelve el último nodo de la cola
     * @return pLast de la cola
     */
    public Nodo<T> getpLast() {
        return pLast;
    }

    /**
     * Método que asigna el último nodo de la cola
     * @param pLast el Plast a ser asignado
     */
    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
    }

    /**
     * Método que retorna el tamaño de la cola
     * @return tamaño de la cola
     */
    public int getSize() {
        return size;
    }

    /**
     * Método que asigna el tamaño de la cola
     * @param size el tamaño a ser asignado
     */
    public void setSize(int size) {
        this.size = size;
    }
    
}
