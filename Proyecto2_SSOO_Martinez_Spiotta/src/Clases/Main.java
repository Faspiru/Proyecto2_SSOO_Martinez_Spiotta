/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Queue;
import Interfaces.MainInterface;

/**
 *
 * @author fabriziospiotta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Queue colaPrueba = new Queue();
//        
//        colaPrueba.encolar(1);
//        colaPrueba.encolar(4);
//        colaPrueba.encolar(6);
//        colaPrueba.encolar(9);
//        colaPrueba.encolar(10);
//        
//        String cadena = colaPrueba.converterToString();
//        System.out.println(cadena);
//        
//        Character personaje = new Character(2, "Faspa", 2, 3, 4, 5, "p");
        String [] arrayAvatarCharacters = new String[] {"Aang", "Ch2", "Ch3", "Ch4", "Ch5", "Ch6", "Ch7", "Ch8", "Ch9", "Ch10"};
        String [] arrayAvatarCharactersImgRoutes = new String[] {"R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10"};
        String [] arrayUnShowMasCharacters = new String[] {"Mordecai", "Ch2", "Ch3", "Ch4", "Ch5", "Ch6", "Ch7", "Ch8", "Ch9", "Ch10"};
        String [] arrayUnShowMasCharactersImgRoutes = new String[] {"R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10"};
        
        Company nickelodeon = new Company(arrayAvatarCharacters, arrayAvatarCharactersImgRoutes);
        Company cartoonNetwork = new Company(arrayUnShowMasCharacters, arrayUnShowMasCharactersImgRoutes);
        
        //OS so = new OS();
        
        //so.generateCharacterAvatar();
        //System.out.println("hola");
        
        MainInterface main = new MainInterface(nickelodeon, cartoonNetwork);
        main.show();
        
        
    }
    
}
