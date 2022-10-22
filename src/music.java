
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vashtileonie
 */
public class music {
    
   public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
      Scanner scan= new Scanner(System.in);
      
      File file = new File("src/bgm.wav");
      AudioInputStream audioStream= AudioSystem.getAudioInputStream(file);
      Clip clip= AudioSystem.getClip();
      clip.open(audioStream);
       
      System.out.print("Enter your choice: ");
      String response = "";
      response= response.toUpperCase();
       
       
       response = scan.next();
       
       switch(response){
           case("P"): clip.start();
           break;
           case("S"): clip.stop();
           break;
       }
       
       
       
   }
}
