/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E03_AppletMethods;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**

 @author metin
 */
@SuppressWarnings("all")
public class AppletEvents extends Applet implements MouseListener {

    StringBuffer stringIfade;

    @Override
    public void init () {
        addMouseListener(this);
        stringIfade = new StringBuffer();
        mesajYaz("Yeni bir Applet olusturuldu");
    }

    @Override
    public void start () {
        mesajYaz("Applet baslatildi.");
    }

    @Override
    public void stop () {
        mesajYaz("Durduruluyor...");
    }

    @Override
    public void destroy () {
        mesajYaz("Applet kaldiriliyor...");
    }

    void mesajYaz (String word) {
        System.out.println(word);
        stringIfade.append(word);
        repaint();
    }

    @Override
    public void paint (Graphics g) {
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.drawString(stringIfade.toString(), 10, 20);
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        mesajYaz("Mouse tiklandi!");
    }

    @Override
    public void mousePressed (MouseEvent e) {
    }

    @Override
    public void mouseReleased (MouseEvent e) {
    }

    @Override
    public void mouseEntered (MouseEvent e) {
    }

    @Override
    public void mouseExited (MouseEvent e) {
    }

}
