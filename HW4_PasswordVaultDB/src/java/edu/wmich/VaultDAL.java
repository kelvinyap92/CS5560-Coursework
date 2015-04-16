/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author KelvinYap
 */
@Named(value = "vaultDAL")
@SessionScoped
public class VaultDAL implements Serializable {
    
    @PersistenceUnit(name = "HW4_PasswordVaultDBPU")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction utx;
    
    private String username;
    private String URL;
    private String password;
    
    public VaultDAL() {}
    
  public List getAllVaults() {
     VaultJpaController vjpac = new VaultJpaController(utx, emf);
     return vjpac.findVaultEntities();
  }
    
    public void insertVault() {
        VaultJpaController vjpac = new VaultJpaController(utx, emf);
        Vault vault = new Vault(username, URL, password);
        
        try {
            vjpac.create(vault);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteVault(String username) {
        VaultJpaController vjpac = new VaultJpaController(utx, emf);
        
        try {
            vjpac.destroy(username);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    

 
}
