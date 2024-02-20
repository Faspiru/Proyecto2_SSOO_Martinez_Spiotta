/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.ImageIcon;

/**
 *
 * @author fabriziospiotta
 */
public class Character {
    
    private String id;
    private String nameCharacter;
    private int priorityLevel; // 1, 2 0 3
    private String type;
    private int habilidades;
    private int vida;
    private int fuerza;
    private int agilidad;
    private ImageIcon imgRoute;
    private int counter;

    public Character(String idString, int idNumber, String nameCharacter, int habilidades, int vida, int fuerza, int agilidad, ImageIcon imgRoute) {
        this.id = idString + idNumber;
        this.nameCharacter = nameCharacter;
        this.habilidades = habilidades;
        this.vida = vida;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.type = "";
        this.imgRoute = imgRoute;
        this.counter = 0;
        
        calculateType();
    }
    
    public void calculateType() {        
        int sumaTotal = 0;
        
        if (habilidades >= 500){
            sumaTotal += 1;
        } 
        if (vida >= 500){
            sumaTotal += 1;
        }
        if (fuerza >= 500){
            sumaTotal += 1;
        }
        if (agilidad >= 500){
            sumaTotal += 1;
        }
        
        if (sumaTotal == 4) {
            setPriorityLevel(1);
            setType("Excepcional");
        }
        else if (sumaTotal == 3 ||sumaTotal == 2) {
            setPriorityLevel(2);
            setType("Promedio");
        } 
        else {
            setPriorityLevel(3);
            setType("Deficiente");
        }
    }
    
    public void restart(){
        this.counter = 0;
        priorityLevel -= 1;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nameCharacter
     */
    public String getNameCharacter() {
        return nameCharacter;
    }

    /**
     * @param nameCharacter the nameCharacter to set
     */
    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    /**
     * @return the priorityLevel
     */
    public int getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * @param priorityLevel the priorityLevel to set
     */
    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the habilidades
     */
    public int getHabilidades() {
        return habilidades;
    }

    /**
     * @param habilidades the habilidades to set
     */
    public void setHabilidades(int habilidades) {
        this.habilidades = habilidades;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the fuerza
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * @param fuerza the fuerza to set
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * @return the agilidad
     */
    public int getAgilidad() {
        return agilidad;
    }

    /**
     * @param agilidad the agilidad to set
     */
    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    /**
     * @return the imgRoute
     */
    public ImageIcon getImgRoute() {
        return imgRoute;
    }

    /**
     * @param imgRoute the imgRoute to set
     */
    public void setImgRoute(ImageIcon imgRoute) {
        this.imgRoute = imgRoute;
    }
    
    public int getCounter(){
        return counter;
    }
    
    public void setCounter(int counter){
        this.counter =counter;
    }
    
    
    
}
