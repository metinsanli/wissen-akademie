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
public class Sekil3_DaireElips extends Applet {

    @Override
    public void paint (Graphics g) {
        g.drawOval(20, 20, 150, 150);
        g.drawOval(160, 110, 140, 80);
    }

}
