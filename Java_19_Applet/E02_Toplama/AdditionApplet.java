/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E02_Toplama;

import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

/**

 @author metin
 */
@SuppressWarnings("all")
public class AdditionApplet extends JApplet {

    private double sum;

    @Override
    public void init () {
        String firstNumber = JOptionPane.showInputDialog(this, "Ondalik sayi giriniz : (1) ");
        String secondNumber = JOptionPane.showInputDialog(this, "Ondalik sayi giriniz : (2) ");

        double number1 = Double.parseDouble(firstNumber);
        double number2 = Double.parseDouble(secondNumber);

        sum = number1 + number2;
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        g.drawRect(15, 10, 270, 20);
        g.drawString("Toplam = " + sum, 25, 25);
    }

}
