/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;


/**
 *
 * @author KelvinYap
 */
@Named(value = "javaBean")
@SessionScoped
public class JavaBean implements Serializable {
    
     
    public JavaBean(){}
    
    public void upload(FileUploadEvent event) {
        try{
            File targetFolder = new File("C:\\Users\\KelvinYap\\Documents\\NetBeansProjects\\Midterm_Q2\\web\\images");
            InputStream inputFile = event.getFile().getInputstream();
            OutputStream outputFile = new FileOutputStream(new File(targetFolder,
            event.getFile().getFileName()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read = inputFile.read(bytes)) != -1){
                outputFile.write(bytes, 0, read);
            }
            inputFile.close();
            outputFile.flush();
            outputFile.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
}
