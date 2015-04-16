/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KelvinYap
 */
@Entity
@Table(name = "VAULT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vault.findAll", query = "SELECT v FROM Vault v"),
    @NamedQuery(name = "Vault.findByUsername", query = "SELECT v FROM Vault v WHERE v.username = :username"),
    @NamedQuery(name = "Vault.findByUrl", query = "SELECT v FROM Vault v WHERE v.url = :url"),
    @NamedQuery(name = "Vault.findByPassword", query = "SELECT v FROM Vault v WHERE v.password = :password")})
public class Vault implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 50)
    @Column(name = "URL")
    private String url;
    @Size(max = 30)
    @Column(name = "PASSWORD")
    private String password;

    public Vault() {
    }

    public Vault(String username, String URL, String password) {
        this.username = username;
        this.url = URL;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vault)) {
            return false;
        }
        Vault other = (Vault) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.wmich.Vault[ username=" + username + " ]";
    }
    
}
