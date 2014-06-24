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
public class Sekil2_Merdiven extends Applet {

    public void paint (Graphics g) {
        int x = 20, y = 20;
        for (int i = 0; i < 5; i++) {
            g.drawLine(x, y, x + 20, y);
            g.drawLine(x + 20, y, x + 20, y);
            x = x + 20;
            y = y + 20;
        }
    }

}
