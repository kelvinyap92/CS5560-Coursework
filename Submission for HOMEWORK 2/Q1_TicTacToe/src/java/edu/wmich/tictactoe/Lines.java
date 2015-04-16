/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich.tictactoe;

/**
 *
 * @author KelvinYap
 */
public class Lines {
    
    private Game.State[] lineInfo;
    private int lineIndex;
    
    public Lines(Game.State[] lineStuff, int lineIndex){
        this.lineInfo = lineStuff;
        this.lineIndex = lineIndex;
    }
    public Game.State[] getLineInfo(){
        return lineInfo;
    }
    public int getIndex() {
        return lineIndex;
    }
}

