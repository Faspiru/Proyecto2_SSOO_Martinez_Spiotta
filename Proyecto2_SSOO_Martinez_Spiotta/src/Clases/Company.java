/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Queue;

/**
 *
 * @author fabriziospiotta
 */
public class Company {
    
    private Queue colaAlta;
    private Queue colaMedia;
    private Queue colaBaja;   
    private Queue colaRefuerzo;
    private String [] arrayCharacters;
    private String [] arrayCharactersImgRoutes;

    public Company(String[] arrayCharacters, String[] arrayCharactersImgRoutes) {
        this.colaAlta = new Queue();
        this.colaMedia = new Queue();
        this.colaBaja = new Queue();
        this.colaRefuerzo = new Queue();
        this.arrayCharacters = arrayCharacters;
        this.arrayCharactersImgRoutes = arrayCharactersImgRoutes;
    }

    public Queue getColaAlta() {
        return colaAlta;
    }

    public void setColaAlta(Queue colaAlta) {
        this.colaAlta = colaAlta;
    }

    public Queue getColaMedia() {
        return colaMedia;
    }

    public void setColaMedia(Queue colaMedia) {
        this.colaMedia = colaMedia;
    }

    public Queue getColaBaja() {
        return colaBaja;
    }

    public void setColaBaja(Queue colaBaja) {
        this.colaBaja = colaBaja;
    }

    public Queue getColaRefuerzo() {
        return colaRefuerzo;
    }

    public void setColaRefuerzo(Queue colaRefuerzo) {
        this.colaRefuerzo = colaRefuerzo;
    }

    public String[] getArrayCharacters() {
        return arrayCharacters;
    }

    public void setArrayCharacters(String[] arrayCharacters) {
        this.arrayCharacters = arrayCharacters;
    }

    public String[] getArrayCharactersImgRoutes() {
        return arrayCharactersImgRoutes;
    }

    public void setArrayCharactersImgRoutes(String[] arrayCharactersImgRoutes) {
        this.arrayCharactersImgRoutes = arrayCharactersImgRoutes;
    }
    
    
}
