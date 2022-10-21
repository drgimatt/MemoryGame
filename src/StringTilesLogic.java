
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author boxro
 */
public class StringTilesLogic implements ActionListener{
    MainGame text = new MainGame();       
    Boolean purgatory = false;
    Boolean shown = true;
    int level = text.x;
    int temp = 30;
    int temp2 = 30;
    
    private static StringTilesLogic logic = null;

    private StringTilesLogic(){
    }

    public static StringTilesLogic getInstance(){
        if (logic == null){
            logic = new StringTilesLogic();
        }
        return logic;
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for(int i =0;i<(level*2);i++){//gameplay when a button is pressed
			if(source==text.btn[i]){
				if(shown){
					hideField(level);//if first time, hides field
				}else{//otherwise play
					switchSpot(i);
					if(temp>=(level*2)){
						temp=i;
					} else {
						if((text.board[temp]!=text.board[i])||(temp==i)){
							temp2=i;
							purgatory=true;
							
							
						} else {
							text.board[i]="done";
							text.board[temp]="done";
							//checkWin();
							temp=(level*2);
						}
						
					}
				}
				
			}
			
			
		}
    
    
    }
    public void hideField(int x){//this sets all the boxes blank
            for(int i=0;i<(x*2);i++){
                    text.btn[i].setText("");		
            }
            shown=false;
    }
    public void switchSpot(int i){//this will switch the current spot to either blank or what it should have
            if(text.board[i]!="done"){//when a match is correctly chosen, it will no longer switch when pressed
            if(text.btn[i].getText()==""){
                    text.btn[i].setText(text.board[i]);
                    //shown=true;
            } else {
                    text.btn[i].setText("");
                    //shown=false;
            }
            }
    }
    public void showSpot(int i){
            text.btn[i].setText(text.board[i]);
    }
    public void showField(int x, String a[]){//this shows all the symbols on the field
            for(int i=0;i<(x*2);i++){
                    text.btn[i].setText(a[i]);
            }
            shown=true;
    }
    
    
    
    
}
