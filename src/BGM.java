
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vashtileonie
 */
public class BGM {
    
    Long currentFrame;
    Clip clip;
    String status;
    AudioInputStream audioInputStream;
    static String filePath;   
    
    public BGM()throws UnsupportedAudioFileException, IOException, LineUnavailableException 
    {
        // create AudioInputStream object
        audioInputStream = 
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
          
        // create clip reference
        clip = AudioSystem.getClip();
          
        // open audioInputStream to the clip
        clip.open(audioInputStream);
          
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public static void main(String[] args) 
    {
      
        try
        {
            filePath = "sc/bgm.wav";
            BGM audioPlayer = new BGM();
              
            audioPlayer.play();
            Scanner sc = new Scanner(System.in);
            
            while (true)
            {
                System.out.println("1. play");
                System.out.println("2. stop");
                int c = sc.nextInt();
                audioPlayer.gotoChoice(c);
                if (c == 4)
                break;
            }
            sc.close();
        
        }catch (Exception ex) 
        {
            System.out.println("Error with playing sound.");
          }
    }

    private void gotoChoice(int c)
            throws IOException, LineUnavailableException, UnsupportedAudioFileException 
    {
        switch (c) 
        {
            case 1:
                play();
                break;
            case 2:
                stop();
                break;
        }
      
    }
   public void play() {
       clip.start();
       status= "play";
    }
   public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException 
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }
    
}
