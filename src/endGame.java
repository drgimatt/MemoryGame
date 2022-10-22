
import java.util.TimerTask;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author boxro
 */
public class endGame extends TimerTask{
    MainGame game;
    tryAgain again;
    
    public endGame(MainGame game, tryAgain again){
        this.game=game;
        this.again=again;
    }
   
    
    public void run() {
       game.dispose();
       again.show();
    }
    
}
