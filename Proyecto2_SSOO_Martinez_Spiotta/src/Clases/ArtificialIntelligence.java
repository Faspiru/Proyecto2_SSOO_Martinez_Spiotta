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
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author fabriziospiotta
 */
public class ArtificialIntelligence extends Thread{
    private Character unShowMas;
    private Character avatar;
    private Character ganador;
    private Queue ganadores;
    private String status;
    private Semaphore mutex;
    private Semaphore mutex2;
    private Semaphore mutex3;
    private int duration;
    private int result;
    private int batles;
    private int avatarWins;
    private int unShowMasWins;
    
    private JLabel[] labels;
    private JTextArea ganadoresTextArea;
    
    public ArtificialIntelligence(Semaphore mutex, Semaphore mutex2, Semaphore mutex3){
        this.unShowMas = null;
        this.avatar = null;
        this.ganador = null;
        int result = 0;
        int batles = 0;
        this.status = "Esperando";
        this.duration = 10000; // Cambiar a 10000
        this.mutex = mutex;
        this.mutex2 = mutex2;
        this.mutex3 = mutex3;
    }
    
    @Override
    public void run(){
        while(true) {
            try {  
                if (!statusAI("Esperando")){
                    work();
                    sleep(duration);
                    setStatusAI("Anunciando");
                    labels[12].setText(status);
//                    labels[13].setText(Integer.toString(avatarWins));
//                    labels[14].setText(Integer.toString(unShowMasWins));
                    sleep(4000); // Revisar
                    labels[13].setText(Integer.toString(avatarWins));
                    labels[14].setText(Integer.toString(unShowMasWins));
                    show();
                    setStatusAI("Esperando");
                    labels[12].setText(status);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger("").log(Level.SEVERE, null, ex);
            }
        }
    }
    
 
    public boolean statusAI(String stat){
        boolean value = false;
        try {
            mutex.acquire(); //wait
            value = status.equals(stat); //critica
            mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    public void setStatusAI(String stat){
        try {
            mutex.acquire(); //wait
            status = (stat); //critica
            mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }
    }
    
    public void battlesAI(){
        try {
            mutex2.acquire(); //wait
            batles += 1; //critica
            mutex2.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }
    }

    
    public void work(){
        try {
            mutex3.acquire(); //wait
            double percentage = Math.random();
            if (percentage <= 0.4) { // 40% de probabilidad de ganar 
                decision();
                result = 1;
            } else if (percentage <= 0.67){ // 27% de probabilidad de empatar
                result = 2;
            } else { // 33% de probabilidad de anular
                result = 3;
            }
            System.out.println("\nResultado --> " + result);
            mutex3.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger("").log(Level.SEVERE, null, ex);
        }
        battlesAI();
    }
    
    public void decision(){
        int puntosa = 0;
        int puntosu = 0;
        
        // Indice de Combate
        double ica = (0.3*avatar.getFuerza()) + (0.3*avatar.getVida()) + (0.2*avatar.getAgilidad()) + (0.2*avatar.getHabilidades());
        double icu = (0.3*unShowMas.getFuerza()) + (0.3*unShowMas.getVida()) + (0.2*unShowMas.getAgilidad()) + (0.2*unShowMas.getHabilidades());
        
        if (ica > icu){
            puntosa += 1;
        } else if (icu > ica) {
            puntosu += 1;
        } else {
            double aleatorio = Math.random()*3;
            
            if (aleatorio <= 1){
                puntosa += 1;
            } else {
                puntosu += 1;
            }
        }
        
        
        // Indice de Suerte
        double suerte = Math.random()*1.5;
        
        if (puntosa > puntosu){
            if (puntosa >= suerte){
                ganador = avatar;
            } else {
                ganador = unShowMas;
            }
        } else {
            if (puntosu >= suerte){
                ganador = unShowMas;
            } else {
                ganador = avatar;
            }
        } 
        
        if (ganador.getId().contains("U")) {
            unShowMasWins++;
            
        } else {
            avatarWins++;
            
        }
    }
    
    public void show(){
        if (result == 1) {
            labels[15].setText("GANADOR: " + ganador.getId() + " " + ganador.getNameCharacter());
        }
        else if (result == 2) {
            labels[15].setText("EMPATE");
        } else {
            labels[15].setText("COMBATE ANULADO");
        }
        
        ganadoresTextArea.setText(ganadores.converterToStringNick());
        // Etiquetas, pero si result == 1, hay un ganador en el atributo ganador
        // Si result == 2 empate, y si result == 3 no se pudo llevar a cabo
    }

    public Character getUnShowMas() {
        return unShowMas;
    }

    public void setUnShowMas(Character unShowMas) {
        this.unShowMas = unShowMas;
    }

    public Character getAvatar() {
        return avatar;
    }

    public void setAvatar(Character avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Character getGanador() {
        return ganador;
    }

    public void setGanador(Character ganador) {
        this.ganador = ganador;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public int getBatles() {
        return batles;
    }

    public void setBatles(int batles) {
        this.batles = batles;
    }

    public JLabel[] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }

    public JTextArea getGanadoresTextArea() {
        return ganadoresTextArea;
    }

    public void setGanadoresTextArea(JTextArea ganadoresTextArea) {
        this.ganadoresTextArea = ganadoresTextArea;
    }

    public Queue getGanadores() {
        return ganadores;
    }

    public void setGanadores(Queue ganadores) {
        this.ganadores = ganadores;
    }
    
    
    
    
}
