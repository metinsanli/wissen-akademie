/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wissen.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**

 @author metin
 */
@Stateless
public class TblKisiFacade extends AbstractFacade<TblKisi> {
    @PersistenceContext(unitName = "com.mycompany_Java_21_MAVEN01_Deneme_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager () {
        return em;
    }

    public TblKisiFacade () {
        super(TblKisi.class);
    }
    
}
