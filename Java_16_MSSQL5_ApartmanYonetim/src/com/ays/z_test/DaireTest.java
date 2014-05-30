/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.z_test;

import com.ays.databaseop.DBCommit;
import com.ays.databaseop.DBConn;
import com.ays.entity.Gider;
import com.ays.entity.Kisi;
import java.sql.Date;

/**

 @author metin
 */
public class DaireTest {

    public static void main (String[] args) {
        Gider gider = new Gider("10", "Sercan");
        DBConn baglanti = new DBConn();
        int sonuc = baglanti.updateGider(gider);
        System.out.println(sonuc == 1 ? "OK." : "FAIL!");
    }

    public void ciftDatabaseYazma () {
        Kisi kisi = new Kisi("176743", "Ahmet", "Beyaz", new Date(3456l), "hhhh@kkme.cn");
        DBCommit baglanti = new DBCommit();
        int i = baglanti.insertKisiDaire(kisi, "20", true);
        System.out.println(i == 1 ? "OK." : "FAIL!");
    }
}
