/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

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
    private int hCalidad;
    private int vCalidad;
    private int fCalidad;
    private int aCalidad;
    private String imgRoute;

    public Character(String idString, int idNumber, String nameCharacter, int habilidades, int vida, int fuerza, int agilidad, String imgRoute) {
        this.id = idString + idNumber;
        this.nameCharacter = nameCharacter;
        this.habilidades = habilidades;
        this.vida = vida;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.hCalidad = 0;
        this.vCalidad = 0;
        this.fCalidad = 0;
        this.aCalidad = 0;
        this.imgRoute = imgRoute;
        
        calculateType();
    }
    
    public void calculateType() {
        double numberH = Math.random();
        double numberV = Math.random();
        double numberF = Math.random();
        double numberA = Math.random();
        
        if (numberH <= 0.6) {
            sethCalidad(gethCalidad() + 1);
        }
        if (numberV <= 0.7) {
            setvCalidad(getvCalidad() + 1);
        }
        if (numberF <= 0.5) {
            setfCalidad(getfCalidad() + 1);
        }
        if (numberA <= 0.4) {
            setaCalidad(getaCalidad() + 1);
        }
        
        int sumaTotal = gethCalidad() + getvCalidad() + getfCalidad() + getaCalidad();
        
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
     * @return the hCalidad
     */
    public int gethCalidad() {
        return hCalidad;
    }

    /**
     * @param hCalidad the hCalidad to set
     */
    public void sethCalidad(int hCalidad) {
        this.hCalidad = hCalidad;
    }

    /**
     * @return the vCalidad
     */
    public int getvCalidad() {
        return vCalidad;
    }

    /**
     * @param vCalidad the vCalidad to set
     */
    public void setvCalidad(int vCalidad) {
        this.vCalidad = vCalidad;
    }

    /**
     * @return the fCalidad
     */
    public int getfCalidad() {
        return fCalidad;
    }

    /**
     * @param fCalidad the fCalidad to set
     */
    public void setfCalidad(int fCalidad) {
        this.fCalidad = fCalidad;
    }

    /**
     * @return the aCalidad
     */
    public int getaCalidad() {
        return aCalidad;
    }

    /**
     * @param aCalidad the aCalidad to set
     */
    public void setaCalidad(int aCalidad) {
        this.aCalidad = aCalidad;
    }

    /**
     * @return the imgRoute
     */
    public String getImgRoute() {
        return imgRoute;
    }

    /**
     * @param imgRoute the imgRoute to set
     */
    public void setImgRoute(String imgRoute) {
        this.imgRoute = imgRoute;
    }
    
    
    
}
