/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KelvinYap
 */

@Named (value = "javaBean")
@SessionScoped
public class JavaBean implements Serializable{
    
    private String userName;
    private String password;
    private final String validUsername = "test";
    private final String validPassword = "test";
    private boolean authenicated = false;
    
    //Empty Constructor
    public JavaBean(){}
    
public String login() {
  if(getUserName().equals(validUsername) && getPassword().equals(validPassword)){
      authenicated = true;
      return "main";
  } else {
      authenicated = false;
      return "index";
  }
}

public String logout() {
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
    
}
