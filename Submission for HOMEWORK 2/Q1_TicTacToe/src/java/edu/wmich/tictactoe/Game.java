/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wmich.tictactoe;

import java.util.*;

/**
 *
 * @author KelvinYap
 */
public class Game {
    
  private static final int GRID_SIZE = 3;
  private boolean userFirst = true;
  private State[][] gameStatus;
  private static final Random randy = new Random();


   
    
    public enum State{
        NULL, O, X;
    }
    public enum Player{
       
        
        USER(State.X),
        COMPUTER(State.O),
        NOONE(State.NULL);
        
        private State state;
        private Player(State state){
            this.state = state;
       
        }
    }
    
   //Constructor game with empty argument
    public Game() {
        //3X3
       this.gameStatus = new State[GRID_SIZE][GRID_SIZE]; 
    }

    public List<Lines> getGridLines(){
        List<Lines> lines = new ArrayList<>();
        int i =0;
        
        for(State[] lineStuff : this.gameStatus) {
          lines.add(new Lines(lineStuff, i));
          i++;
        }
        return lines;
        }
    
   public List<Cells> getGridStatus(Lines lines) {
    List<Cells> cells = new ArrayList<>();
    int i =0;
    for(State state : lines.getLineInfo()) {
        cells.add(new Cells(state, lines.getIndex(), i));
        i++;
    }
    return cells;
 
 }
   
   public void setStartUser(boolean userFirst){
       this.userFirst = userFirst;
   }
   
   public void startGame(){
       for(int lines = 0; lines < GRID_SIZE; lines++){
           for(int cols = 0; cols < GRID_SIZE; cols++) {
               this.gameStatus[lines][cols] = State.NULL;
           }
       }
       if(!this.userFirst){
           this.start(Player.COMPUTER, 1, 1);
       }
       
   }
   
     private void start(Player player, int lines, int cols) {
       
         if(this.gameStatus[lines][cols] == State.NULL) {
             this.gameStatus[lines][cols] = player.state;
         }
    }
     
     public void playerTurn(int lines, int cols){
         this.start(Player.USER, lines, cols);
     }
     
     public void computerTurn() {
         int lines = this.getLineEmpty();
         int cols = this.getRandomEmptyCells(lines);
         this.start(Player.COMPUTER, lines, cols);
        
     }
   
    private Player getPlayer(State state){
       for(Player player : Player.values()) {
           if(player.state.equals(state)) {
               
               return player;
           }
       }
       return null;
       
    }
    
    public Player getWinner() {
    
        //Lines/Row
        for(int lines=0; lines<GRID_SIZE; lines++){
        State linesState = this.gameStatus[lines][0];
        boolean win = true;
        for(int cols = 0;  cols < GRID_SIZE; cols++){
         if(!this.gameStatus[lines][cols].equals(linesState)){
           win = false;
           break;
         }
         
        }
        if(win) {
            return this.getPlayer(linesState);              
     }
    }
        
       //Cols
        for(int cols=0; cols<GRID_SIZE; cols++){
        State colsState = this.gameStatus[0][cols];
        boolean win = true;
        for(int lines =0; lines<GRID_SIZE; lines++) {
          if(!this.gameStatus[lines][cols].equals(colsState)) {
            win = false;
            break;
          }
        }
        if(win){
        return this.getPlayer(colsState);
        }
        }
        
        //Draw
        State pDraw = this.gameStatus[0][0];
        State nDraw = this.gameStatus[0][GRID_SIZE - 1];
        boolean pWin = true;
        boolean nWin = true;
        
        for(int i=0; i<GRID_SIZE; i++) {
           if(!this.gameStatus[i][i].equals(pDraw)) {
           pWin = false;
           }
           if(!this.gameStatus[i][GRID_SIZE - 1 - i].equals(nDraw)) {
           
           nWin = false;
           }
        }
        if(pWin) {
             return this.getPlayer(pDraw);
        }
        else if (nWin) {
             return this.getPlayer(nDraw);
        }
        else {
            return Player.NOONE;
        }
        
    }

    
    
    
    private int getLineEmpty() {
      if(!this.hasEmptyCells()) {
      return -1;
      }
      List<Integer> indexes = new ArrayList();
      int i=0;
      for(State[] lines: this.gameStatus){
          boolean hasEmpty = false;
          for(State cell: lines){
              if(cell == State.NULL){
                 hasEmpty = true;
                 break;
              }
          }
          if(hasEmpty){
               indexes.add(new Integer(i));
          }
         i++;
      }
      return indexes.get(randy.nextInt(indexes.size()));
    }

    private int getRandomEmptyCells(int lines) {
        if(!this.hasEmptyCells()){
        return -1;
        }
        
        List<Integer> indexes = new ArrayList();
        int i=0;
        for(State cells : this.gameStatus[lines]) {
            if(cells == State.NULL){
                indexes.add(new Integer(i));
            }
            i++;
        }
       return indexes.get(randy.nextInt(indexes.size()));
    }
  
   public boolean hasEmptyCells(){
       for(int l=0; l < GRID_SIZE; l++){
           for(int c=0; c < GRID_SIZE; c++) {
               if(this.gameStatus[l][c] == State.NULL) {
                   return true;
               }
              
           }
       }
       return false;
   }
       
}

