package java04_ProgressBar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MainClass {
  public static void main(String args[]) throws Exception {
    JFrame frame = new JFrame("Indeterminate");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JProgressBar aJProgressBar = new JProgressBar();
    aJProgressBar.setIndeterminate(true);
    frame.add(aJProgressBar, BorderLayout.NORTH);
    frame.setSize(300, 100);
    frame.pack();
    frame.setVisible(true);
  }

}