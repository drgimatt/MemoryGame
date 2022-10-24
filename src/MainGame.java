
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Timer;
import javax.swing.UIManager;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author boxro
 */

public class MainGame extends javax.swing.JFrame implements MouseListener {

    /**
     * Creates new form OptionsPage
     */
    
    int tiles = 0;
    int totalTiles = 0;
    int length = 0;
    int firstSelected = 40;
    int secondSelected = 40;
    int correctTiles = 0;
    int incorrectTiles = 0;
    int tries = 0;
    int gameDuration = 0;
    boolean bombTilesFlag = false;
    private boolean resetColorSelect = false;
    private boolean resetTextSelect = false;
    boolean tilesAreText = false;
    boolean showTilesInitial = true;
    Font font;
    Color standard = new Color(220, 220, 220);
    Random randomGenerator = new Random();
    JButton btn[] = new JButton[50];
    String[] board;
    Color[] Colorboard;
    Color[] color = {Color.blue,Color.green,Color.orange,Color.black,Color.pink,Color.red,Color.magenta,Color.cyan};
    //String[] SymbolFranc = {"✫","(✉)","♛","♧","☼","☋","✞","☹"};
    String[] EquationFranc = {"F=ma","E=m²", "a²+b²=c²", "log(100)=2", "2 x sin30°", "a²-b² = (a+b)(a-b)", "a³+b³ = (a+b)(a²-ab+b²)", "D = b²-4ac", "A= L x W", "(a-b)² = a²-2ab+b²","x = −b ± √b²-4ac/2a","V =1/3 πr 2h","m = y2 – y1 / x2 – x1","S = 4 x π x r 2","a = π * r²","logxy = logx + logy","i^2= −1","F - E + V = 2"};
    String[] symbols = {"(￣y▽,￣)╭ ","(┬┬﹏┬┬)","(￢︿̫̿￢☆)","`(*>﹏<*)′","(づ ᴗ _ᴗ)づ","(^・ω・^ )","ฅ^•ﻌ•^ฅ","o(^▽^)o"};
    String[] equations = {"F=ma","E=m²", "a²+b²=c²", "log(100)=2", "2 x sin30°", "W = Fs", "y=mx+b", "D = b²-4ac", "A = L x W", "FC = mv²/r","C = Q/V","V =1/3 πr 2h","Ax + By = C","S = 4πr²","a = π * r²","𝒂(𝒙 − 𝒉)²+ 𝒌","i^2= −1","F - E + V = 2"};
    String[] symbolsBomb ={"💣","(┬┬﹏┬┬)","(￢︿̫̿￢☆)","`(*>﹏<*)′","(づ ᴗ _ᴗ)づ","(^・ω・^ )","˙ᘧ ͜ ˙","o(^▽^)o"};
    String[] equationsBomb = {"F=ma","E=m²", "a²+b²=c²", "log(100)=2", "2 x sin30°", "a²-b² = (a+b)(a-b)", "💣", "D = b²-4ac", "A= L x W", "(a-b)² = a²-2ab+b²","x = −b ± √b²-4ac/2a","V =1/3 πr 2h","m = y2 – y1 / x2 – x1","S = 4 x π x r 2","a = π * r²","logxy = logx + logy","i^2= −1","F - E + V = 2"};
    String ans [] = new String[40];
    tryAgain tryAgain= new tryAgain();
    
    public void backgroundScale() throws MalformedURLException{
            final ImageIcon originalImage = new javax.swing.ImageIcon(getClass().getResource("/Images/mainBG.png"));
            final ImageIcon scaledImage = new ImageIcon(originalImage.getImage()
                .getScaledInstance(920, 610, Image.SCALE_SMOOTH));
            Background.setIcon(scaledImage);
    }
    
    public void difficultySelect(String difficulty){
        if(difficulty == "easy"){
            setUpGameColor();
        }
        else{
            setUpGameText(difficulty);
        }
           
    }
    
    public void durationTime(){
        if(gameDuration > 0){
        TimerTask task = new endGame(this,tryAgain);
        Timer timer = new Timer();
        timer.schedule(task, gameDuration);
        }
    }    
    
    public void initializeStats(){
        firstSelected = 40;
        secondSelected = 40;
        correctTiles = 0;
        incorrectTiles = 0;
        tries = 0;
        resetTextSelect= false;
        resetColorSelect = false;
        showTilesInitial = true; 
    }
    
    public void setUpGameColor(){
        initializeStats();
        durationTime();
        firstSelected = 40;
        secondSelected = 40;
        tilesAreText = false;
        tiles = 4;
        length = color.length;
        Colorboard = new Color[20];
        totalTiles = (int) Math.pow(tiles, 2);
        MainGame.setLayout(new GridLayout(4,4,2,2));
        
        for(int i=0;i<totalTiles;i++){
			btn[i] = new JButton("");
                        btn[i].setBackground(standard); 
       			btn[i].setEnabled(true);
                        btn[i].addMouseListener(this);
                        btn[i].setRolloverEnabled(true);
			MainGame.add(btn[i]);
		
		}
        
        for(int i=0;i<length;i++){
            for(int z=0;z<2;z++){
		while(true){	
			int y = randomGenerator.nextInt(length*2);
			if(Colorboard[y]==null){
			btn[y].setBackground(color[i]);
                        Colorboard[y]=color[i];
			break;
			}
		}
            }		
	           
        }
    }
    
    public void setUpGameText(String flag){
        initializeStats();
        durationTime();
        tilesAreText = true;
        
        if(flag == "average") {
            tiles = 4;
            MainGame.setLayout(new GridLayout(4,4,2,2));
            if(bombTilesFlag){
            ans = symbolsBomb;
            length = symbolsBomb.length;
            }
            else{
            ans = symbols;
            length = symbols.length;
            }
        }
        else if (flag == "difficult"){ 
            tiles = 6;
            MainGame.setLayout(new GridLayout(6,6,2,2));
            if(bombTilesFlag){
            ans = equationsBomb;
            length = equationsBomb.length;
            }
            else{
            ans = equations;
            length = equations.length;
            }
        }

        totalTiles = (int) Math.pow(tiles, 2);
        board = new String [totalTiles];
        for(int i=0;i<(totalTiles);i++){
			btn[i] = new JButton("");
			btn[i].setBackground(standard);
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
        if(bombTilesFlag){
        hideAllTileText();
        }
    }    
    
    
    public void showSpecificTileText(int i){
        btn[i].setText(board[i]);
    }
    
    public void flipTileText(int i){
        if(board[i] != "matched"){
            if(btn[i].getText()==""){
                showSpecificTileText(i);
            }
            else{
                btn[i].setText("");
            }
        }
    }
    
    public void hideAllTileText(){
        for(int i=0; i<totalTiles; i++){
           btn[i].setText("");
           showTilesInitial = false;
        }
    }    

    public void showSpecificTileColor(int i){
        btn[i].setBackground(Colorboard[i]);
    }

    public void flipTileColor(int i){                       
        if(Colorboard[i] != Color.yellow){
            if(btn[i].getBackground()== standard){
                showSpecificTileColor(i);
            }
            else{
                btn[i].setBackground(standard);
            }
        }
    }
    
    public void hideAllTileColor(){
        for(int i=0; i<totalTiles; i++){
           btn[i].setBackground(standard);
           showTilesInitial = false;
        }
    }
    
    public boolean checkWinText(){
        for(int i=0; i<totalTiles; i++){
            if (board[i] != "matched"){
            return false;
            } 
        }
        playerWon();
        return true;
    }

    public boolean checkWinColor(){
        for(int i=0; i<totalTiles; i++){
            if (Colorboard[i].getRGB() != Colorboard[firstSelected].getRGB()){
            return false;
            } 
        }
        playerWon();
        return true;
    }
    
    public void playerWon(){
        //JOptionPane.showMessageDialog(null,"Congratulations. You won!","WINNER",JOptionPane.PLAIN_MESSAGE);
        wonTryAgain tryAgain= new wonTryAgain();
        tryAgain.show();
        dispose();
    }
    
    public void purgeColor(){
                flipTileColor(secondSelected);
                flipTileColor(firstSelected);
                firstSelected = totalTiles;
                secondSelected = 40;
                resetColorSelect = false;
    }
    
    public void purgeText(){
                flipTileText(secondSelected);
                flipTileText(firstSelected);
                firstSelected = totalTiles;
                secondSelected = 40;
                resetTextSelect = false;
    }
    
    public MainGame() throws MalformedURLException {
        initComponents();
        FrameCenter.centerJFrame(this);
        backgroundScale();
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
        NumCorrMatchLabel = new javax.swing.JLabel();
        NumIncorrMatchLabel = new javax.swing.JLabel();
        NumCorrMatch = new javax.swing.JLabel();
        NumIncorrMatch = new javax.swing.JLabel();
        NumClick = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        endGame = new javax.swing.JButton();
        NumClickLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Game = new javax.swing.JMenu();
        NewGame = new javax.swing.JMenuItem();
        Quit = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        Instruction = new javax.swing.JMenuItem();
        About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 610));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainGame.setBackground(new java.awt.Color(153, 0, 102));
        MainGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        MainGame.setForeground(new java.awt.Color(255, 102, 102));
        MainGame.setOpaque(false);
        MainGame.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(MainGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 650, 500));

        Stats.setEnabled(false);
        Stats.setOpaque(false);

        NumCorrMatchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumCorrMatchLabel.setText("Number of Correct Matches:");
        NumCorrMatchLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        NumIncorrMatchLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumIncorrMatchLabel.setText("Number of Incorrect Matches:");
        NumIncorrMatchLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        NumCorrMatch.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        NumCorrMatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumCorrMatch.setText("0");

        NumIncorrMatch.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        NumIncorrMatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumIncorrMatch.setText("0");

        NumClick.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        NumClick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumClick.setText("0");

        Time.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setText("0");

        endGame.setBackground(new java.awt.Color(204, 204, 255));
        endGame.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        endGame.setForeground(new java.awt.Color(0, 51, 51));
        endGame.setText("END GAME");
        endGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endGameActionPerformed(evt);
            }
        });

        NumClickLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumClickLabel.setText("Number of Attempted Matches:");
        NumClickLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeLabel.setText("Elapsed Time:");
        TimeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout StatsLayout = new javax.swing.GroupLayout(Stats);
        Stats.setLayout(StatsLayout);
        StatsLayout.setHorizontalGroup(
            StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(NumCorrMatchLabel)
                    .addComponent(NumCorrMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumIncorrMatchLabel)
                    .addComponent(NumIncorrMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endGame, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumClick, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumClickLabel)
                    .addComponent(TimeLabel))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        StatsLayout.setVerticalGroup(
            StatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StatsLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(TimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(NumClickLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumClick, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NumCorrMatchLabel)
                .addGap(18, 18, 18)
                .addComponent(NumCorrMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NumIncorrMatchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumIncorrMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(endGame, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        getContentPane().add(Stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 230, 470));

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setMaximumSize(new java.awt.Dimension(661, 610));
        Background.setMinimumSize(new java.awt.Dimension(661, 610));
        Background.setPreferredSize(new java.awt.Dimension(661, 610));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 570));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
        dispose();
        OptionsPage options = new OptionsPage();
        options.show();
    }//GEN-LAST:event_NewGameActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:
        AboutPage about = new AboutPage();
        about.show();
        //JOptionPane.showMessageDialog(null, "MemoryGame \nVersion 1.0-ALPHA\nMembers:\nAlthea Louise Cruz\nFrancoise Tuala \nKatrice Asher\nMiguel Escandor\nVashti Bauson", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AboutActionPerformed

    private void InstructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructionActionPerformed
        // TODO add your handling code here:
        InstPage help = new InstPage();
        help.show();

    }//GEN-LAST:event_InstructionActionPerformed

    private void endGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endGameActionPerformed
        // TODO add your handling code here:
        tryAgain.show();
        dispose();
    }//GEN-LAST:event_endGameActionPerformed

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
                try {
                    new MainGame().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        } catch( Exception ex ) {
                System.err.println( "Failed to initialize LaF" );
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JLabel Background;
    private javax.swing.JMenu Game;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Instruction;
    private javax.swing.JPanel MainGame;
    private javax.swing.JMenuItem NewGame;
    private javax.swing.JLabel NumClick;
    private javax.swing.JLabel NumClickLabel;
    private javax.swing.JLabel NumCorrMatch;
    private javax.swing.JLabel NumCorrMatchLabel;
    private javax.swing.JLabel NumIncorrMatch;
    private javax.swing.JLabel NumIncorrMatchLabel;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JPanel Stats;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JButton endGame;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mousePressed(MouseEvent e) {
    Object source = e.getSource();
            
            if(resetTextSelect){
                purgeText();
            }
             if(resetColorSelect){
                purgeColor();
            }
            for (int i = 0; i < totalTiles; i++){
            
            if (source == btn[i]){
                if (tilesAreText == true){
                    if(bombTilesFlag){//Word Bomb Logic
                    if(showTilesInitial == true){
                        hideAllTileText();
                    }
                    else{
                        flipTileText(i);
                        if(firstSelected >= totalTiles){
                            firstSelected = i;
                            }
                            else{
                                if((board[firstSelected] != board[i]) || (firstSelected == i)){
                                    secondSelected = i;
                                    resetTextSelect = true;
                                    incorrectTiles++;
                                    tries++;
                                    NumCorrMatch.setText(Integer.toString(correctTiles));
                                    NumIncorrMatch.setText(Integer.toString(incorrectTiles));
                                    NumClick.setText(Integer.toString(tries));                                    
                                }
                                else{
                                    if(board[i]== "💣" && board[firstSelected] == "💣"){
                                        dispose();
                                        tryAgain.show();
                                    }
                                    else{
                                    board[i]="matched";
                                    board[firstSelected] = "matched";
                                    correctTiles++;
                                    tries++;
                                    NumCorrMatch.setText(Integer.toString(correctTiles));
                                    NumIncorrMatch.setText(Integer.toString(incorrectTiles));
                                    NumClick.setText(Integer.toString(tries));
                                    if(correctTiles == length - 1){
                                        playerWon();
                                    }
                                    checkWinText();
                                    firstSelected = totalTiles;
                                    }
                                }
                                
                            }                    
                    }
                    }
                    else{ //Word Normal Logic
                    if(showTilesInitial == true){
                        hideAllTileText();
                    }
                    else{
                        flipTileText(i);
                        if(firstSelected >= totalTiles){
                            firstSelected = i;
                            }
                            else{
                            if((board[firstSelected] == "matched") || (board[i] == "matched")){
                                    secondSelected = i;
                                    resetTextSelect = true;
                                    NumCorrMatch.setText(Integer.toString(correctTiles));
                                    NumIncorrMatch.setText(Integer.toString(incorrectTiles));
                                    NumClick.setText(Integer.toString(tries));                                    
                                } 
                            else if((board[firstSelected] != board[i]) || (firstSelected == i)){
                                    secondSelected = i;
                                    resetTextSelect = true;
                                    incorrectTiles++;
                                    tries++;
                                    NumCorrMatch.setText(Integer.toString(correctTiles));
                                    NumIncorrMatch.setText(Integer.toString(incorrectTiles));
                                    NumClick.setText(Integer.toString(tries));                                    
                                }
                                else{
                                    board[i]="matched";
                                    board[firstSelected] = "matched";
                                    correctTiles++;
                                    tries++;
                                    NumCorrMatch.setText(Integer.toString(correctTiles));
                                    NumIncorrMatch.setText(Integer.toString(incorrectTiles));
                                    NumClick.setText(Integer.toString(tries));
                                    checkWinText();
                                    firstSelected = totalTiles;
                                }
                                
                            }                    
                    }                    
                    }
                } 
                else{// Color Logic
                    if(showTilesInitial == true){
                        hideAllTileColor();
                    }
                    else{
                        flipTileColor(i);
                        if(firstSelected >= totalTiles){
                            firstSelected = i;
                        }
                        else{
                            if((Colorboard[i].getRGB() == Color.yellow.getRGB()) || (Colorboard[firstSelected].getRGB() == Color.yellow.getRGB())){
                                secondSelected = i;
                                resetColorSelect = true;
                                NumCorrMatch.setText(Integer.toString(correctTiles));
                                NumIncorrMatch.setText(Integer.toString(incorrectTiles));
                                NumClick.setText(Integer.toString(tries));
                            }
                            else if(Colorboard[i].getRGB() != Colorboard[firstSelected].getRGB() || (i == firstSelected)){
                                secondSelected = i;
                                resetColorSelect = true;
                                incorrectTiles++;
                                tries++;
                                NumCorrMatch.setText(Integer.toString(correctTiles));
                                NumIncorrMatch.setText(Integer.toString(incorrectTiles));
                                NumClick.setText(Integer.toString(tries));
                            }
                            else{
                                correctTiles++;
                                tries++;
                                NumCorrMatch.setText(Integer.toString(correctTiles));
                                NumIncorrMatch.setText(Integer.toString(incorrectTiles));
                                NumClick.setText(Integer.toString(tries));
                                Colorboard[firstSelected] = Color.yellow;
                                Colorboard[i] = Color.yellow;
                                checkWinColor();
                                firstSelected = totalTiles;
                            }
                        }
                    }
                }
            }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
