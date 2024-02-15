/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


/**
 *
 * @author fabriziospiotta
 */
public class OS {
    
    private Company nickelodeon;
    private Company cartoonNetwork;
    private int counterAvatarID;
    private int counterUnShowMasID;


    public OS(Company nickelodeon, Company cartoonNetwork) {
        this.nickelodeon = nickelodeon;
        this.cartoonNetwork = cartoonNetwork;
        this.counterAvatarID = 1;
        this.counterUnShowMasID = 1;

    }
    
    public void generateCharacterAvatar() {
        
        // Creamos las stats del personaje de forma aleatoria
        int habilidadesStat = (int) (Math.random() * 901) + 100;
        int vidaStat = (int) (Math.random() * 901) + 100;
        int fuerzaStat = (int) (Math.random() * 901) + 100;
        int agilidadStat = (int) (Math.random() * 901) + 100;
        
        // Se escoge aleatoriamente que personaje se va a crear
        int numberCharacter = (int) (Math.random() * 10);
 
        Character personaje = new Character("A", counterAvatarID, nickelodeon.getArrayCharacters()[numberCharacter],  habilidadesStat, vidaStat, fuerzaStat, agilidadStat, nickelodeon.getArrayCharactersImgRoutes()[numberCharacter]);
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
      
}
