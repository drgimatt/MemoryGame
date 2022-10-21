
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author altheacruz
 */
public class OptionsPage extends javax.swing.JFrame {

    /**
     * Creates new form StartPage
     */
    
    String diff = "easy";
    
    public OptionsPage() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGrpRestrict = new javax.swing.ButtonGroup();
        difficulty = new javax.swing.ButtonGroup();
        MovementRestrict = new javax.swing.JRadioButton();
        MovementFree = new javax.swing.JRadioButton();
        BombTilesEnable = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        Easy = new javax.swing.JRadioButton();
        Average = new javax.swing.JRadioButton();
        Difficult = new javax.swing.JRadioButton();
        ok = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        MovementLabel = new javax.swing.JLabel();
        MovementLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btGrpRestrict.add(MovementRestrict);
        MovementRestrict.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MovementRestrict.setForeground(new java.awt.Color(255, 255, 255));
        MovementRestrict.setText("Yes");
        getContentPane().add(MovementRestrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        btGrpRestrict.add(MovementFree);
        MovementFree.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MovementFree.setForeground(new java.awt.Color(255, 255, 255));
        MovementFree.setSelected(true);
        MovementFree.setText("No");
        getContentPane().add(MovementFree, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 51, -1));

        BombTilesEnable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BombTilesEnable.setForeground(new java.awt.Color(255, 255, 255));
        BombTilesEnable.setText("Enable Bomb Tiles");
        BombTilesEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BombTilesEnableActionPerformed(evt);
            }
        });
        getContentPane().add(BombTilesEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        difficulty.add(Easy);
        Easy.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Easy.setForeground(new java.awt.Color(255, 255, 255));
        Easy.setSelected(true);
        Easy.setText("Easy");
        Easy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EasyItemStateChanged(evt);
            }
        });
        Easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EasyActionPerformed(evt);
            }
        });

        difficulty.add(Average);
        Average.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Average.setForeground(new java.awt.Color(255, 255, 255));
        Average.setText("Average");
        Average.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AverageItemStateChanged(evt);
            }
        });

        difficulty.add(Difficult);
        Difficult.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Difficult.setForeground(new java.awt.Color(255, 255, 255));
        Difficult.setText("Difficult");
        Difficult.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DifficultItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Easy)
                    .addComponent(Difficult)
                    .addComponent(Average))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(Easy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Average)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Difficult))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 130, 90));

        ok.setBackground(new java.awt.Color(0, 255, 153));
        ok.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        ok.setForeground(new java.awt.Color(0, 51, 51));
        ok.setText("OK");
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okMouseClicked(evt);
            }
        });
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 90, 30));

        exit1.setBackground(new java.awt.Color(255, 51, 153));
        exit1.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        exit1.setForeground(new java.awt.Color(255, 204, 204));
        exit1.setText("CANCEL");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });
        getContentPane().add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 100, 30));
        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        MovementLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MovementLabel.setForeground(new java.awt.Color(255, 255, 255));
        MovementLabel.setText("movements?");
        MovementLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(MovementLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 160, 20));

        MovementLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MovementLabel1.setForeground(new java.awt.Color(255, 255, 255));
        MovementLabel1.setText("Restrict number of ");
        MovementLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(MovementLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 160, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/optBG.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BombTilesEnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BombTilesEnableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BombTilesEnableActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        
        if(diff=="easy"){
        MainGame easy = new MainGame();
        easy.show();
        easy.difficultySelect("easy");
     }else if(diff=="ave"){
        MainGame ave = new MainGame();
        ave.show();
        ave.difficultySelect("average");
     }else if(diff=="hard"){
        MainGame hard = new MainGame();
        hard.show();
        hard.difficultySelect("difficult");
     }
    }//GEN-LAST:event_okActionPerformed

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
        // TODO add your handling code here:
        StartPage start= new StartPage();
        start.show();
    }//GEN-LAST:event_exit1ActionPerformed

    private void EasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EasyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EasyActionPerformed

    private void EasyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EasyItemStateChanged
        // TODO add your handling code here:         
        diff= "easy";
    }//GEN-LAST:event_EasyItemStateChanged

    private void AverageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AverageItemStateChanged
        // TODO add your handling code here:
        diff= "ave";      
    }//GEN-LAST:event_AverageItemStateChanged

    private void DifficultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DifficultItemStateChanged
        // TODO add your handling code here:
        diff= "hard";
 
    }//GEN-LAST:event_DifficultItemStateChanged

    private void okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_okMouseClicked
    
    
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
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try{
        UIManager.setLookAndFeel( new FlatDarkLaf() );
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionsPage().setVisible(true);
            }
        });
        } catch( Exception ex ) {
                System.err.println( "Failed to initialize LaF" );
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Average;
    private javax.swing.JCheckBox BombTilesEnable;
    private javax.swing.JRadioButton Difficult;
    private javax.swing.JRadioButton Easy;
    private javax.swing.JRadioButton MovementFree;
    private javax.swing.JLabel MovementLabel;
    private javax.swing.JLabel MovementLabel1;
    private javax.swing.JRadioButton MovementRestrict;
    private javax.swing.ButtonGroup btGrpRestrict;
    private javax.swing.ButtonGroup difficulty;
    private javax.swing.JButton exit1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables
}
