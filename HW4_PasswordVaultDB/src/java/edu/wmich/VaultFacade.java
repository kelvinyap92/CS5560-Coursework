/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author KelvinYap
 */
@Stateless
public class VaultFacade extends AbstractFacade<Vault> {
    @PersistenceContext(unitName = "HW4_PasswordVaultDBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VaultFacade() {
        super(Vault.class);
    }
    
}
