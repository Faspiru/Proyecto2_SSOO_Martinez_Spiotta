/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Queue;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fabriziospiotta
 */
public class OS extends Thread{
    
    private Company nickelodeon;
    private Company cartoonNetwork;
    private Queue ganadores;
    private int rounds;
    private int counterAvatarID;
    private int counterUnShowMasID;
    private Character chosenOneA;
    private Character chosenOneU;
    
    private ArtificialIntelligence ai;
    private Semaphore mutex;
    private Semaphore mutex2;
    private Semaphore mutex3;
    private int batles;


    public OS(Company nickelodeon, Company cartoonNetwork, ArtificialIntelligence ai, Semaphore mutex, Semaphore mutex2, Semaphore mutex3) {
        this.nickelodeon = nickelodeon;
        this.cartoonNetwork = cartoonNetwork;
        this.ganadores = new Queue();
        this.ai = ai;
        this.rounds = 0;
        this.counterAvatarID = 1;
        this.counterUnShowMasID = 1;
        this.chosenOneA = null;
        this.chosenOneU = null;
        this.mutex = mutex;
        this.mutex2 = mutex2;
        this.mutex3 = mutex3;
        this.batles = 0;
        generate();
        System.out.println("Prioridad Alta --> ");
        System.out.println(nickelodeon.getColaAlta().converterToString());
        System.out.println(cartoonNetwork.getColaAlta().converterToString());
        System.out.println("\nPrioridad Media --> ");
        System.out.println(nickelodeon.getColaMedia().converterToString());
        System.out.println(cartoonNetwork.getColaMedia().converterToString());
        System.out.println("\nPrioridad Baja --> ");
        System.out.println(nickelodeon.getColaBaja().converterToString());
        System.out.println(cartoonNetwork.getColaBaja().converterToString());
        ai.start();
    }
    
    @Override
    public void run(){
        while(true) {
            try {  
                if (rounds == 8){
                    rounds = 0;
                    double percentage = Math.random();

                    if (percentage <= 0.8){
                        generateCharacterAvatar();
                        generateCharacterUnShowMas();
                    }
                }

                if (statusAI("Esperando")){
                    chosenOneA = choose(nickelodeon);
                    chosenOneU = choose(cartoonNetwork);
                    ai.setAvatar(chosenOneA);
                    ai.setUnShowMas(chosenOneU);
                    setStatusAI("Decidiendo");
                    rounds += 1;
                    batles += 1;

                    while(true){
                        if (battlesAI()){
                            int result = resultAI();

                            if (result == 1){
                                ganadores.encolar(ai.getGanador());
                            } else if (result == 2){
                                nickelodeon.getColaAlta().encolar(chosenOneA);
                                cartoonNetwork.getColaAlta().encolar(chosenOneU);
                            } else {
                                nickelodeon.getColaRefuerzo().encolar(chosenOneA);
                                cartoonNetwork.getColaRefuerzo().encolar(chosenOneU);
                            }
                            System.out.println("\nPrioridad Alta --> ");
                            System.out.println(nickelodeon.getColaAlta().converterToString());
                            System.out.println(cartoonNetwork.getColaAlta().converterToString());
                            System.out.println("\nPrioridad Media --> ");
                            System.out.println(nickelodeon.getColaMedia().converterToString());
                            System.out.println(cartoonNetwork.getColaMedia().converterToString());
                            System.out.println("\nPrioridad Baja --> ");
                            System.out.println(nickelodeon.getColaBaja().converterToString());
                            System.out.println(cartoonNetwork.getColaBaja().converterToString());
                            System.out.println("\nRefuerzo --> ");
                            System.out.println(nickelodeon.getColaRefuerzo().converterToString());
                            System.out.println(cartoonNetwork.getColaRefuerzo().converterToString());
                            System.out.println("\nGanadores --> ");
                            System.out.println(ganadores.converterToString());
                            break;
                        }
                    }
                }

                manejoColaRefuerzo(nickelodeon);
                manejoColaRefuerzo(cartoonNetwork);
                sleep(0);
            } catch (InterruptedException ex) {
                Logger.getLogger("").log(Level.SEVERE, null, ex);
            }
        }
    }
    
  
    public boolean statusAI(String stat){
        boolean value = false;
        try {
            mutex.acquire(); //wait
            value = ai.getStatus().equals(stat); //critica
            mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    public void setStatusAI(String stat){
        try {
            mutex.acquire(); //wait
            ai.setStatus(stat); //critica
            mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean battlesAI(){
        boolean value = false;
        try {
            mutex2.acquire(); //wait
            value = (ai.getBatles() == batles); //critica
            mutex2.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    public int resultAI(){
        int valaue = 0;
        try {
            mutex3.acquire(); //wait
            valaue = ai.getResult(); //critica
            mutex3.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }
        return valaue;
    }
    
    
    public Character choose(Company company){
        boolean exist = false;
        Character chosenOne = null;
        
        while (!exist){
            if (!company.getColaAlta().esVacia()){
                chosenOne = company.getColaAlta().poll();
                exist = true;
            } else if (!company.getColaMedia().esVacia()){
                chosenOne = company.getColaMedia().poll();
                exist = true;
            } else if (!company.getColaBaja().esVacia()){
                chosenOne = company.getColaBaja().poll();
                exist = true;
            } else {
                generateCharacterAvatar();
            }
        }
        
        return chosenOne;
    }
    
    public void generate(){
        for (int i = 1; i <= 20; i ++){
            generateCharacterAvatar();
            generateCharacterUnShowMas();
        }
    }
    
    public void generateCharacterAvatar() {
        int habilidades = generateValue(0.6);
        int vida = generateValue(0.7);
        int fuerza = generateValue(0.5);
        int agilidad = generateValue(0.4);

        // Se escoge aleatoriamente que personaje se va a crear
        int numberCharacter = (int) (Math.random() * 10);
 
        Character personaje = new Character("A", counterAvatarID, nickelodeon.getArrayCharacters()[numberCharacter],  habilidades, vida, fuerza, agilidad, nickelodeon.getArrayCharactersImgRoutes()[numberCharacter]);
        if (personaje.getPriorityLevel() == 1) {
            nickelodeon.getColaAlta().encolar(personaje);
        }
        else if (personaje.getPriorityLevel() == 2) {
            nickelodeon.getColaMedia().encolar(personaje);
        }
        else {
            nickelodeon.getColaBaja().encolar(personaje);
        }
      
        counterAvatarID ++;
    }
    
    
    public void generateCharacterUnShowMas() {
        
        // Creamos las stats del personaje de forma aleatoria
        int habilidadesStat = (int) (Math.random() * 901) + 100;
        int vidaStat = (int) (Math.random() * 901) + 100;
        int fuerzaStat = (int) (Math.random() * 901) + 100;
        int agilidadStat = (int) (Math.random() * 901) + 100;
        
        // Se escoge aleatoriamente que personaje se va a crear
        int numberCharacter = (int) (Math.random() * 10);
 
        Character personaje = new Character("U", counterUnShowMasID, cartoonNetwork.getArrayCharacters()[numberCharacter],  habilidadesStat, vidaStat, fuerzaStat, agilidadStat, cartoonNetwork.getArrayCharactersImgRoutes()[numberCharacter]);
        if (personaje.getPriorityLevel() == 1) {
            cartoonNetwork.getColaAlta().encolar(personaje);
        }
        else if (personaje.getPriorityLevel() == 2) {
            cartoonNetwork.getColaMedia().encolar(personaje);
        }
        else {
            cartoonNetwork.getColaBaja().encolar(personaje);
        }
        
        counterUnShowMasID ++;
    }
    
    
    public int generateValue(double porcentaje){
        double percentage = Math.random();
        int number;
        
        if (percentage <= porcentaje) {
            number = (int) (Math.random() * 501) + 500;
        } else {
            number = (int) (Math.random() * 400) + 100;
        }
        
        return number;
    }
    
    
    public void manejoColaRefuerzo(Company company){
        if (!company.getColaRefuerzo().esVacia()){
            double percentage = Math.random();
            Character nuevo = company.getColaRefuerzo().poll();
            
            if (percentage <= 0.4){
                int f = generateUpgrade(nuevo.getFuerza());
                int a = generateUpgrade(nuevo.getAgilidad());
                int h = generateUpgrade(nuevo.getHabilidades());
                int v = generateUpgrade(nuevo.getHabilidades());

                nuevo.setFuerza(f);
                nuevo.setAgilidad(a);
                nuevo.setHabilidades(h);
                nuevo.setVida(v);
                
                company.getColaAlta().encolar(nuevo);
            }else {
                company.getColaRefuerzo().encolar(nuevo);
            }
        }
    }
    
    public int generateUpgrade(int attribute){
        int number = (int) (Math.random() * 100) + 1;
        
        int upgrade = attribute + (int)(attribute*(number/100));
        
        if (upgrade > 1000){
            return 1000;
        } else {
            return upgrade;
        }
    }
}
