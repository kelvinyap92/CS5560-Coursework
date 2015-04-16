/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KelvinYap
 */

@Named (value = "javaBean")
@SessionScoped
public class JavaBean implements Serializable {
    
    private String userName;
    private String password;
    private final String validUsername = "test";
    private final String validPassword = "test";
    private boolean authenicated = false;
    
    private String user;
    private String pass;
    private String URL;
    
    private ArrayList<Vault> allItems = new ArrayList<>();
    
    
    //Empty Constructor
    public JavaBean() {
    }
    
    public String login() {
       if(getUserName().equals(validUsername) && getPassword().equals(validPassword)) {
           authenicated = true;
          return "main";
       } else {
           authenicated = false;
           return "index";
       }
      
    }
    
    public String logout(){
        authenicated = false;
        return "index";
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     * @return the authenicated
     */
    public boolean isAuthenicated() {
        return authenicated;
    }

 
    /**
     * @return the allItems
     */
    public ArrayList<Vault> getAllItems() {
        return allItems;
    }

    /**
     * @param allItems the allItems to set
     */
    public void setAllItems(ArrayList<Vault> allItems) {
        this.allItems = allItems;
    }
      
    
    public String deleteItems(Vault v){
      allItems.remove(v);
      return "main";
    }
    
    public String addItems(){
       allItems.add(new Vault(user, pass, URL));
       return "main";
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
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
    
    
    
}
