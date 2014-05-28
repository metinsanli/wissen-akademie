/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.test;

import com.ays.entity.Kisi;
import java.sql.Date;

/**

 @author metin
 */
public class KisiTest {

    public static void main (String[] mt) {
        long h = 10l;
        Date dt = new Date(h);
        Kisi kisi = new Kisi("1234", "Mert", "Tert", dt);
        System.out.println(kisi.getAd());

    }
}
