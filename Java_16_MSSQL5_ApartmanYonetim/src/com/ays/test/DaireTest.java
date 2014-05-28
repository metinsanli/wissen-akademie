/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.test;

import com.ays.databaseop.DBConn;
import com.ays.entity.Daire;
import java.util.ArrayList;

/**

 @author metin
 */
public class DaireTest {

    public static void main (String[] mt) {
        //tablodanCek();
        //daireCek();
        //daireGuncelle();
        kisiYarat();

    }

    public static void kisiYarat () {
        System.out.println();
    }

    public static void tablodanCek () {
        DBConn baglanti = new DBConn();
        ArrayList<Daire> daireler = baglanti.getAllDaire();
        System.out.println("Daire Adedi : " + daireler.size());
        for (Daire d : daireler) {
            System.out.println("Daire No : " + d.getDaireNo());
        }
    }

    public static void daireCek () {
        DBConn baglanti = new DBConn();
        Daire daire = baglanti.getDaire("1");
        System.out.println("Daire No : " + daire.getDaireNo());
        System.out.println("Dublex   : " + daire.isDublex());
    }

    public static void daireGuncelle () {
        DBConn connection = new DBConn();
        Daire daire = connection.getDaire("1");
        System.out.println(daire.getCephe());
        daire.setCephe("Metin");

        connection.updateDaire(daire);

        daire = connection.getDaire("1");
        System.out.println(daire.getCephe());
    }

} // END CLASS
