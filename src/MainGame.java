
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author boxro
 */
public class MainGame extends javax.swing.JFrame implements MouseListener{

    /**
     * Creates new form OptionsPage
     */
    
    int tiles = 0;
    int totalTiles = 0;
    int length = 0;
    Random randomGenerator = new Random();
    JButton btn[] = new JButton[50];
    String[] board;
    Color[] color = {Color.white,Color.blue,Color.green,Color.orange,Color.yellow,Color.black,Color.pink,Color.red,Color.magenta,Color.cyan};
    String[] symbols = {"(￣y▽,￣)╭ ","(┬┬﹏┬┬)","(￢︿̫̿￢☆)","`(*>﹏<*)′","ƪ(˘⌣˘)ʃ","(^・ω・^ )","~~>_<~~","o(^▽^)o"};//easier version
    String[] equations = {"F=ma","E=m²", "a²+b²=c²", "log(100)=2", "2 x sin30°", "a²-b² = (a+b)(a-b)", "a³+b³ = (a+b)(a²-ab+b²)", "D = b²-4ac", "A= L x W", "(a-b)² = a²-2ab+b²"}; //math equations
    String ans [] = new String[25];
    
    public void difficultySelect(String difficulty){
        if(difficulty == "easy"){
            setUpGameColor();
        }
        else if (difficulty == "average"){
            setUpGameText("average");
        }
        else if (difficulty == "difficult"){
            setUpGameText("difficult");
        }
            
    }
    
    public void setUpGameColor(){
        ans = symbols;
        tiles = 4;
        length = 8;
        MainGame.setLayout(new GridLayout(4,4,2,2));
        Color ans [] = new Color[14];
        totalTiles = (int) Math.pow(tiles, 2);
        Color Colorboard [] = new Color [totalTiles];
        for(int i=0;i<totalTiles;i++){
			btn[i] = new JButton("");
                        btn[i].setBackground(new Color(220, 220, 220)); 
       			btn[i].setEnabled(true);
			MainGame.add(btn[i]);
		
		}

        
        for (int i = 0; i < length; i++){
            ans[i] = color[i];
        }
        

        for(int i=0;i<length;i++){
            for(int z=0;z<2;z++){
		while(true){	
			int y = randomGenerator.nextInt(length*2);
			if(Colorboard[y]==null){
			btn[y].setBackground(ans[i]);
			Colorboard[y]=ans[i];
			break;
			}
		}
            }
				
			
	}
}
    
    public void setUpGameText(String flag){
          
        if(flag == "average") {
            ans = symbols;
            tiles = 4;
            length = symbols.length;
            MainGame.setLayout(new GridLayout(4,4,2,2));
        }
        else if (flag == "difficult"){ 
            ans = equations;
            tiles = 6;
            length = equations.length;
            MainGame.setLayout(new GridLayout(6,6,2,2));
        }

        
        totalTiles = (int) Math.pow(tiles, 2);
        System.out.println(flag);
        System.out.println(totalTiles);
        board = new String [totalTiles];
        for(int i=0;i<(totalTiles);i++){
			btn[i] = new JButton("");
			btn[i].setBackground(new Color(220, 220, 220));
                        btn[i].setForeground(Color.black);
			btn[i].setEnabled(true);
                        btn[i].addMouseListener(this);
			MainGame.add(btn[i]);
		
		}

        for(int i=0;i<length;i++){
            for(int z=0;z<2;z++){
		while(true){	
			int y = randomGenerator.nextInt(length*2);
			if(board[y]==null){
			btn[y].setText(ans[i]);
			board[y]=ans[i];
			break;
			}
		}
            }
				
			
	}
}    

    
    public MainGame() {
        initComponents();
        difficultySelect("easy");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainGame = new javax.swing.JPanel();
        Stats = new javax.swing.JPanel();
        NumClickLabel = new javax.swing.JLabel();
        NumCorrMatchLabel = new javax.swing.JLabel();
        NumIncorrMatchLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NumClickLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Game = new javax.swing.JMenu();
        NewGame = new javax.swing.JMenuItem();
        Quit = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        Instruction = new javax.swing.JMenuItem();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainGame.setBackground(new java.awt.Color(153, 0, 102));
        MainGame.setForeground(new java.awt.Color(255, 102, 102));
        MainGame.setLayout(new java.awt.GridLayout(5, 5));

        NumClickLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumClickLabel.setText("Number of Clicks:");
        NumClickLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        NumCorrMatchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumCorrMatchLabel.setText("Number of Correct Matches:");
        NumCorrMatchLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        NumIncorrMatchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumIncorrMatchLabel.setText("Number of Incorrect Matches:");
        NumIncorrMatchLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("1");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("4");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("5");

        NumClickLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumClickLabel1.setText("Elapsed Time:");
        NumClickLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("5:30");

        javax.swing.GroupLayout StatsLayout = new javax.swing.GroupLayout(Stats);
        Stats.setLayout(StatsLayout);
        StatsLayout.setHorizontalGroup(
            StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatsLayout.createSequentialGroup()
                .addGroup(StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StatsLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(NumCorrMatchLabel)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumIncorrMatchLabel)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(StatsLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(NumClickLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(NumClickLabel)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        StatsLayout.setVerticalGroup(
            StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(StatsLayout.createSequentialGroup()
                        .addComponent(NumClickLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StatsLayout.createSequentialGroup()
                        .addComponent(NumClickLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(NumCorrMatchLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NumIncorrMatchLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        Game.setText("Game");

        NewGame.setText("New Game");
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });
        Game.add(NewGame);

        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        Game.add(Quit);

        jMenuBar1.add(Game);

        Help.setText("Help");

        Instruction.setText("Instructions");
        Instruction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionActionPerformed(evt);
            }
        });
        Help.add(Instruction);

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(MainGame, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Stats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewGameActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "MemoryGame \nVersion 1.0-ALPHA\nMembers:\nAlthea Louise Cruz\nFrancoise Tuala \nKatrice Asher\nMiguel Escandor\nVashti Leonie", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AboutActionPerformed

    private void InstructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructionActionPerformed
        // TODO add your handling code here:
        InstPage help = new InstPage();
        help.show();
    }//GEN-LAST:event_InstructionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        try{
        UIManager.setLookAndFeel( new FlatDarkLaf() );
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGame().setVisible(true);
            }
        });
        } catch( Exception ex ) {
                System.err.println( "Failed to initialize LaF" );
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenu Game;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Instruction;
    private javax.swing.JPanel MainGame;
    private javax.swing.JMenuItem NewGame;
    private javax.swing.JLabel NumClickLabel;
    private javax.swing.JLabel NumClickLabel1;
    private javax.swing.JLabel NumCorrMatchLabel;
    private javax.swing.JLabel NumIncorrMatchLabel;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JPanel Stats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
    Object source = e.getSource();
            for (int i = 0; i < totalTiles; i++){
            if (source == btn[i]){
                System.out.println(btn[i].getText());
        }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
