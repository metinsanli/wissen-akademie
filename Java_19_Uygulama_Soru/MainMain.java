package com.wissen.soru;

import java.lang.reflect.InvocationTargetException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**

 @author metin
 */
@SuppressWarnings("all")
public class MainMain extends javax.swing.JApplet {

    private static SoruPanel soruPanel;
    private static SkorPanel skorPanel;

    @Override
    public void init () {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "MainMain.init()\n" + ex.getMessage());
        }
        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run () {
                    initComponents();

                }
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            JOptionPane.showMessageDialog(null, "MainMain.init()\n" + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        Quiz = new javax.swing.JMenu();
        jmNew = new javax.swing.JMenuItem();
        Point = new javax.swing.JMenu();
        jmTopFive = new javax.swing.JMenuItem();
        menuTest = new javax.swing.JMenu();
        jmTest = new javax.swing.JMenuItem();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("anapanel"); // NOI18N

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        Quiz.setText("Quiz");

        jmNew.setText("New");
        jmNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNewActionPerformed(evt);
            }
        });
        Quiz.add(jmNew);

        menuBar.add(Quiz);

        Point.setText("Points");

        jmTopFive.setText("Top 5");
        jmTopFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTopFiveActionPerformed(evt);
            }
        });
        Point.add(jmTopFive);

        menuBar.add(Point);

        menuTest.setText("Test");

        jmTest.setText("Conn Test");
        jmTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTestActionPerformed(evt);
            }
        });
        menuTest.add(jmTest);

        menuBar.add(menuTest);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void closeNew () {
        soruPanel = null;
    }

    public static void closeSkor () {
        skorPanel = null;
    }

    private void jmNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNewActionPerformed
        if (soruPanel == null) {
            soruPanel = new SoruPanel(new DB().getSorular());
            desktopPane.add(soruPanel);
        }
    }//GEN-LAST:event_jmNewActionPerformed

    private void jmTopFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTopFiveActionPerformed
        // TODO add your handling code here:
        if (skorPanel == null) {
            skorPanel = new SkorPanel();
            desktopPane.add(skorPanel);
        }
    }//GEN-LAST:event_jmTopFiveActionPerformed

    private void jmTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTestActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "TEST");
    }//GEN-LAST:event_jmTestActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Point;
    private javax.swing.JMenu Quiz;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem jmNew;
    private javax.swing.JMenuItem jmTest;
    private javax.swing.JMenuItem jmTopFive;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuTest;
    // End of variables declaration//GEN-END:variables
}
