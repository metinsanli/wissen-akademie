/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E04_SekilCizme;

import java.applet.Applet;
import java.awt.Graphics;

/**

 @author metin
 */
public class Sekil1_UcgenCizimi extends Applet {

    @Override
    public void paint (Graphics g) {
        drawTriangle(g, 80, 150, 90, 110);
        drawTriangle(g, 125, 160, 60, 70);
    }

    public void drawTriangle (Graphics g, int bottomX, int bottomY, int base, int height) {
        int rightX = bottomX + base;
        int topX = bottomX + base / 2;
        int topY = bottomY - height;

        g.drawLine(bottomX, bottomY, rightX, bottomY);
        g.drawLine(rightX, bottomY, topX, topY);
        g.drawLine(topX, topY, bottomX, bottomY);
    }

}
