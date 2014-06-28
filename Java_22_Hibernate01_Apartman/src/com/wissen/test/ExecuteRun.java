package com.wissen.test;

import com.wissen.entity.TblDaire;
import com.wissen.entity.TblKisi;
import java.util.Date;
import java.util.HashSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ExecuteRun {

    public static void main (String[] args) {
        Date date = new Date();
        HashSet<TblDaire> daireler = new HashSet<>();
        TblDaire daire = new TblDaire("01");
        daireler.add(daire);
        TblKisi kisi = new TblKisi("452387645", "Mewlkjlhmet", "wergfhw", date, "r@t.com", daireler);
        addKisi(kisi);
    }

    public static void addKisi (TblKisi kisi) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(kisi);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
