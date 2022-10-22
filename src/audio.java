import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vashtileonie
 */
public class audio {

public static void main(String[] args) {

    class Player {
        void playMusic(String musicLoc){
                 try {
                         File musicPath = new File(musicLoc);
                          if(musicPath.exists()){ 
                                  AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                                  Clip clip = AudioSystem.getClip();
                                  clip.open(audioInput);
                                  clip.start();
                                 JOptionPane.showMessageDialog(null,"Press ok to stop playing");

                           }
                          else{
                                   System.out.println("Couldn't find Music file");
                                }
                }
                catch (Exception ex){
                           ex.printStackTrace();
                     }
           }
}
           //Add your own path
            String filePath ="sc/bgm.wav";
                      Player play = new Player();
                     play.playMusic(filePath);
            }
}

