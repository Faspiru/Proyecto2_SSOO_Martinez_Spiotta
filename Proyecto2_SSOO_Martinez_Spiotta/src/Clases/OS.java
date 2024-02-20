/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Nodo;
import EstructurasDeDatos.Queue;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;


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
    
    private JTextArea[] textAreas;
    private JLabel[] labels;


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
        System.out.println(nickelodeon.getColaAlta().converterToStringNick());
        System.out.println(cartoonNetwork.getColaAlta().converterToStringCartoon());
        System.out.println("\nPrioridad Media --> ");
        System.out.println(nickelodeon.getColaMedia().converterToStringNick());
        System.out.println(cartoonNetwork.getColaMedia().converterToStringCartoon());
        System.out.println("\nPrioridad Baja --> ");
        System.out.println(nickelodeon.getColaBaja().converterToStringNick());
        System.out.println(cartoonNetwork.getColaBaja().converterToStringCartoon());
        ai.start();
    }
    
    @Override
    public void run(){
        while(true) {
            try {  
                if (rounds == 2){
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
                    labels[0].setIcon(chosenOneA.getImgRoute()); // Probando
                    labels[1].setIcon(chosenOneU.getImgRoute()); // Probando
                    labels[2].setText(chosenOneA.getNameCharacter()); // Probando
                    labels[3].setText(chosenOneU.getNameCharacter()); // Probando
                    
                    // Setting de stats
                    
                    // Avatar
                    
                    labels[4].setText(Integer.toString(chosenOneA.getVida()));
                    labels[5].setText(Integer.toString(chosenOneA.getFuerza()));
                    labels[6].setText(Integer.toString(chosenOneA.getHabilidades()));
                    labels[7].setText(Integer.toString(chosenOneA.getAgilidad()));
                    
                    // Un Show Mas
                    
                    labels[8].setText(Integer.toString(chosenOneU.getVida()));
                    labels[9].setText(Integer.toString(chosenOneU.getFuerza()));
                    labels[10].setText(Integer.toString(chosenOneU.getHabilidades()));
                    labels[11].setText(Integer.toString(chosenOneU.getAgilidad()));
                    
                    
                    
                    setStatusAI("Decidiendo");
                    labels[12].setText(ai.getStatus());
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
                            System.out.println("\n\n ROUND --> " + batles);
//                            labels[0].setIcon(nickelodeon.getColaAlta().getpFirst().getElemento().getImgRoute()); // Probando
//                            labels[1].setIcon(cartoonNetwork.getColaAlta().getpFirst().getElemento().getImgRoute()); // Probando
                            //System.out.println("\nPrioridad Alta --> ");
                            textAreas[0].setText(nickelodeon.getColaAlta().converterToStringNick());
                            //System.out.println(nickelodeon.getColaAlta().converterToStringNick());
                            textAreas[4].setText(cartoonNetwork.getColaAlta().converterToStringCartoon());
                            //System.out.println(cartoonNetwork.getColaAlta().converterToStringCartoon());
                            
                            //System.out.println("\nPrioridad Media --> ");
                            textAreas[1].setText(nickelodeon.getColaMedia().converterToStringNick());
                            //System.out.println(nickelodeon.getColaMedia().converterToStringNick());
                            textAreas[5].setText(cartoonNetwork.getColaMedia().converterToStringCartoon());
                            //System.out.println(cartoonNetwork.getColaMedia().converterToStringCartoon());
                            
                            //System.out.println("\nPrioridad Baja --> ");
                            textAreas[2].setText(nickelodeon.getColaBaja().converterToStringNick());
                            //System.out.println(nickelodeon.getColaBaja().converterToStringNick());
                            textAreas[6].setText(cartoonNetwork.getColaBaja().converterToStringCartoon());
                            //System.out.println(cartoonNetwork.getColaBaja().converterToStringCartoon());
                            
                            //System.out.println("\nRefuerzo --> ");
                            textAreas[3].setText(nickelodeon.getColaRefuerzo().converterToStringNick());
                            //System.out.println(nickelodeon.getColaRefuerzo().converterToStringNick());
                            textAreas[7].setText(cartoonNetwork.getColaRefuerzo().converterToStringCartoon());
                            //System.out.println(cartoonNetwork.getColaRefuerzo().converterToStringCartoon());
                            
                            System.out.println("\nGanadores --> ");
                            System.out.println(ganadores.converterToStringNick());
                            
                            //System.out.println("\nNO INANICION -->");
                            modi(nickelodeon);
                            modi(cartoonNetwork);
                            //System.out.println("\nPrioridad Alta --> ");
                            //System.out.println(nickelodeon.getColaAlta().converterToStringNick());
                            //System.out.println(cartoonNetwork.getColaAlta().converterToStringCartoon());
                            //System.out.println("\nPrioridad Media --> ");
//                            System.out.println(nickelodeon.getColaMedia().converterToStringNick());
//                            System.out.println(cartoonNetwork.getColaMedia().converterToStringCartoon());
//                            System.out.println("\nPrioridad Baja --> ");
//                            System.out.println(nickelodeon.getColaBaja().converterToStringNick());
//                            System.out.println(cartoonNetwork.getColaBaja().converterToStringCartoon());
                            
                            break;
                        }
                    }
                }

                manejoColaRefuerzo(nickelodeon);
                manejoColaRefuerzo(cartoonNetwork);
                sleep(3000); // Para que se vea el esperando
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
        generateCharacterAvatarAlto();
        generateCharacterUnShowMasAlto();
        generateCharacterAvatarAlto();
        generateCharacterUnShowMasAlto();
        
        generateCharacterAvatarMedio();
        generateCharacterUnShowMasMedio();
        
        generateCharacterAvatarBajo();
        generateCharacterUnShowMasBajo();
        
        for (int i = 1; i <= 16; i ++){
            generateCharacterAvatar();
            generateCharacterUnShowMas();
        }
    }
    
    public void generateCharacterAvatarAlto() {
        int habilidades = (int) (Math.random() * 501) + 500;
        int vida = (int) (Math.random() * 501) + 500;
        int fuerza = (int) (Math.random() * 501) + 500;
        int agilidad = (int) (Math.random() * 501) + 500;
        
        int numberCharacter = (int) (Math.random() * 10);
        
        Character personaje = new Character("A", counterAvatarID, nickelodeon.getArrayCharacters()[numberCharacter], habilidades, vida, fuerza, agilidad, nickelodeon.getArrayCharactersImgRoutes()[numberCharacter]);
        nickelodeon.getColaAlta().encolar(personaje);
        
        counterAvatarID ++;
    }
    
    public void generateCharacterAvatarMedio() {
        int habilidades = (int) (Math.random() * 501) + 500;
        int vida = (int) (Math.random() * 501) + 500;
        int fuerza = (int) (Math.random() * 400) + 100;
        int agilidad = (int) (Math.random() * 400) + 100;
        
        int numberCharacter = (int) (Math.random() * 10);
        
        Character personaje = new Character("A", counterAvatarID, nickelodeon.getArrayCharacters()[numberCharacter], habilidades, vida, fuerza, agilidad, nickelodeon.getArrayCharactersImgRoutes()[numberCharacter]);
        nickelodeon.getColaMedia().encolar(personaje);
        
        counterAvatarID ++;
    }
    
    public void generateCharacterAvatarBajo() {
        int habilidades = (int) (Math.random() * 501) + 500;
        int vida = (int) (Math.random() * 400) + 100;
        int fuerza = (int) (Math.random() * 400) + 100;
        int agilidad = (int) (Math.random() * 400) + 100;
        
        int numberCharacter = (int) (Math.random() * 10);
        
        Character personaje = new Character("A", counterAvatarID, nickelodeon.getArrayCharacters()[numberCharacter], habilidades, vida, fuerza, agilidad, nickelodeon.getArrayCharactersImgRoutes()[numberCharacter]);
        nickelodeon.getColaBaja().encolar(personaje);
        
        counterAvatarID ++;
    }
    
    public void generateCharacterUnShowMasAlto() {
        int habilidades = (int) (Math.random() * 501) + 500;
        int vida = (int) (Math.random() * 501) + 500;
        int fuerza = (int) (Math.random() * 501) + 500;
        int agilidad = (int) (Math.random() * 501) + 500;
        
        int numberCharacter = (int) (Math.random() * 10);
        
        Character personaje = new Character("U", counterUnShowMasID, cartoonNetwork.getArrayCharacters()[numberCharacter], habilidades, vida, fuerza, agilidad, cartoonNetwork.getArrayCharactersImgRoutes()[numberCharacter]);
        cartoonNetwork.getColaAlta().encolar(personaje);
        
        counterUnShowMasID ++;
    }
    
    public void generateCharacterUnShowMasMedio() {
        int habilidades = (int) (Math.random() * 501) + 500;
        int vida = (int) (Math.random() * 501) + 500;
        int fuerza = (int) (Math.random() * 400) + 100;
        int agilidad = (int) (Math.random() * 400) + 100;
        
        int numberCharacter = (int) (Math.random() * 10);
        
        Character personaje = new Character("U", counterUnShowMasID, cartoonNetwork.getArrayCharacters()[numberCharacter], habilidades, vida, fuerza, agilidad, cartoonNetwork.getArrayCharactersImgRoutes()[numberCharacter]);
        cartoonNetwork.getColaMedia().encolar(personaje);
        
        counterUnShowMasID ++;
    }
    
    public void generateCharacterUnShowMasBajo() {
        int habilidades = (int) (Math.random() * 501) + 500;
        int vida = (int) (Math.random() * 400) + 100;
        int fuerza = (int) (Math.random() * 400) + 100;
        int agilidad = (int) (Math.random() * 400) + 100;
        
        int numberCharacter = (int) (Math.random() * 10);
        
        Character personaje = new Character("U", counterUnShowMasID, cartoonNetwork.getArrayCharacters()[numberCharacter], habilidades, vida, fuerza, agilidad, cartoonNetwork.getArrayCharactersImgRoutes()[numberCharacter]);
        cartoonNetwork.getColaBaja().encolar(personaje);
        
        counterUnShowMasID ++;
    }
    
    public void generateCharacterAvatar() {
        int habilidades = generateValue(0.6);
        int vida = generateValue(0.7);
        int fuerza = generateValue(0.5);
        int agilidad = generateValue(0.4);

        // Se escoge aleatoriamente que personaje se va a crear
        int numberCharacter = (int) (Math.random() * 10);
 
        Character personaje = new Character("A", counterAvatarID, nickelodeon.getArrayCharacters()[numberCharacter], habilidades, vida, fuerza, agilidad, nickelodeon.getArrayCharactersImgRoutes()[numberCharacter]);
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
 
        Character personaje = new Character("U", counterUnShowMasID, cartoonNetwork.getArrayCharacters()[numberCharacter], habilidadesStat, vidaStat, fuerzaStat, agilidadStat, cartoonNetwork.getArrayCharactersImgRoutes()[numberCharacter]);
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
                nuevo.setPriorityLevel(1);
                
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
    
    public void modi(Company company){
        // Cola Media
        int size = company.getColaMedia().getSize();
        int i = 0;
        Nodo aux = company.getColaMedia().getpFirst();
        while (i < size) {
            if (aux.getElemento().getCounter() == 8){
                Character personaje = company.getColaMedia().desencolarCharacter(aux.getElemento().getId()).getElemento();
                personaje.restart();
                company.getColaAlta().encolar(personaje);
                size -= 1;
            } else {
                aux.getElemento().setCounter(aux.getElemento().getCounter() + 1);
                i += 1;
            }
            aux = aux.getpNext();
        }
       
        // Cola Baja
        aux = company.getColaBaja().getpFirst();
        while (aux != null) {
            if (aux.getElemento().getCounter() == 8){
                Character personaje = company.getColaBaja().desencolarCharacter(aux.getElemento().getId()).getElemento();
                personaje.restart();
                company.getColaMedia().encolar(personaje);
            }else {
                aux.getElemento().setCounter(aux.getElemento().getCounter() + 1);
            }
            aux = aux.getpNext();
        }
    }

    public JTextArea[] getTextAreas() {
        return textAreas;
    }

    public void setTextAreas(JTextArea[] textAreas) {
        this.textAreas = textAreas;
    }

    public JLabel[] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }
    
  
}
