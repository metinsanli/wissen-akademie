package E01_Example;


import java.awt.Graphics;
import javax.swing.JApplet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**

 @author metin
 */
public class WelcomeApplet extends JApplet {

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        g.drawString("Welcome to Java Programing!", 25, 25);
    }
}
