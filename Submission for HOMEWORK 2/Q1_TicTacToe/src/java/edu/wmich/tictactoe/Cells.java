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
public class Cells {
    
    private int cellLines;
    private int cellCols;
     
    private Game.State state;
    
    public Cells(Game.State state, int cellLines, int cellCols)
    {
        this.state = state;
        this.cellLines = cellLines;
        this.cellCols = cellCols;
    }
    
    public Game.State getState(){
        return this.state;
    }
    
    public int getLines() {
        return this.cellLines;
    }
    
    public int getCols(){
        return this.cellCols;
    }
    
    
}
