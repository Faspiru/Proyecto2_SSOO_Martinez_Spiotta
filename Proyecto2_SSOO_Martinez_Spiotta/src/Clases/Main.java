/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Queue;
import Interfaces.MainInterface;
import javax.swing.ImageIcon;

/**
 *
 * @author fabriziospiotta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String [] arrayAvatarCharacters = new String[] {"Aang", "Katara", "Sokka", "Toph", "Appa", "Momo", "Zuko", "Iroh", "Azula", "Korra"};
        String [] arrayAvatarCharactersImgRoutes = new String[] {"src/Imagenes/aang.gif", "src/Imagenes/katara.gif", "src/Imagenes/sokka.gif", "src/Imagenes/Toph.gif", "src/Imagenes/appa.gif", "src/Imagenes/momo.gif", "src/Imagenes/zuko.gif", "src/Imagenes/iroh.gif", "src/Imagenes/azula.gif", "src/Imagenes/korra.gif"};
        String [] arrayUnShowMasCharacters = new String[] {"Mordecai", "Rigby", "Musculoso", "Benson", "Skips", "Papaleta", "Starla", "Margarita", "Fantasmin", "Mr. Maellard"};
        String [] arrayUnShowMasCharactersImgRoutes = new String[] {"src/Imagenes/mordecai.gif", "src/Imagenes/rigby.gif", "src/Imagenes/musculoso.gif", "src/Imagenes/benson.gif", "src/Imagenes/skips.gif", "src/Imagenes/papaleta.gif", "src/Imagenes/starla.gif", "src/Imagenes/margarita.gif", "src/Imagenes/fantasmin.gif", "src/Imagenes/MrMaellard.gif"};
        
        // Crea un array de ImageIcon
        ImageIcon[] arrayAvatarCharactersImg = new ImageIcon[arrayAvatarCharactersImgRoutes.length];
        for (int i = 0; i < arrayAvatarCharactersImgRoutes.length; i++) {
            arrayAvatarCharactersImg[i] = new ImageIcon(arrayAvatarCharactersImgRoutes[i]);
        }
        
        ImageIcon[] arrayUnShowMasCharactersImg = new ImageIcon[arrayUnShowMasCharactersImgRoutes.length];
        for (int i = 0; i < arrayUnShowMasCharactersImgRoutes.length; i++) {
            arrayUnShowMasCharactersImg[i] = new ImageIcon(arrayUnShowMasCharactersImgRoutes[i]);
        }
        
        Company nickelodeon = new Company(arrayAvatarCharacters, arrayAvatarCharactersImg);
        Company cartoonNetwork = new Company(arrayUnShowMasCharacters, arrayUnShowMasCharactersImg);
        
        
        MainInterface main = new MainInterface(nickelodeon, cartoonNetwork);
        main.show();
        
        
    }
    
}
