import java.util.Scanner;
import java.io.*;
import javax.swing.*; 
import java.util.Random;
import java.util.ArrayList;

/**
   @author Devin Walker
   4-29-2015
   CS110
   HW10
   
   This Player class stores hand of a player. There is 1 constuctor which references
   the super class constructor.
*/


public class Player extends Deck{
   private int playerNum; 
   
  /** 
  
  constructor for players hand
  @param player number interger and array list of cards 
  */
   public Player(int playerNum, ArrayList<Card> someCards){
      super(someCards);
      this.playerNum = playerNum;
   }
   
  /**
      the getPlayerNum() method gets the private int playerNum
      @param none
      @return player's number
  */

   public int getPlayerNum(){
      return this.playerNum;
   }
   
   
   /** 
   This method returns a string with information about a player
   @param none
   @return string with info about a hand
   */ 
   public String toString(){
      String str = "Player #" + this.playerNum + "'s hand is: " + super.toString();
      return (str);
   }
}