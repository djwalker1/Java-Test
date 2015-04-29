import java.util.Scanner;
import java.io.*;
import javax.swing.*; 
import java.util.Random;
import java.util.ArrayList;

/**
   @author Devin Walker
   4-29-2015
   CS110
   
   This is a game of war. War is a card game where 2 players split a deck.
   They each draw a card and compare them. Whoever has the highest card takes the drawn cards
   and adds them to the bottom of their deck. The game ends when a player has all of the cards.   
*/

public class War{
   public static void main(String [] args)throws IOException{
      
      //create deck
      Deck deck = new Deck();      
    
      //shuffle deck
      deck.shuffle();
      
      //create 2 players' hand
      //distribute the cards 
      ArrayList<Card> temp = new ArrayList<>();
      
      for(int i = 0; i < 26; i++){ //create a stack for player 1
         temp.add(deck.getDeck().get(i));
      }
      
      Player player1 = new Player(1, temp); //create new player
      
      temp.clear();
      
    
      for(int j = 26; j < 52; j++){ //create new temp stack
         temp.add(deck.getDeck().get(j));
      }
      
      Player player2 = new Player(2, temp); //create new player
      
      //let the game begin
      Scanner keyboard = new Scanner(System.in);
      String input = null;
      boolean valid = false;
      boolean win = false; 
      ArrayList<Card> warPile = new ArrayList<>();

      while(!win){
      
         //ask if player wants to play
         while(!valid){
            System.out.println("Take a turn?(Y/N)");
            input = keyboard.nextLine();
            
            if(input.equalsIgnoreCase("y") | input.equalsIgnoreCase("n")){
               valid = true;
            }
            else{
               System.out.println("Invalid Input. Please input y or n.");
            }        
         }
         
         valid = false; //reintialize
         
         //player wants to continue
         if(input.equalsIgnoreCase("y")){
            if(player1.getDeck().size() > 0 && player2.getDeck().size() > 0){
               //draw
               Card card1 = player1.getDeck().get(0);
               Card card2 = player2.getDeck().get(0);
               player1.removeCard();
               player2.removeCard();
               
               //Cards are equal
               if(card1.equals(card2)){ //Equal cards means war
                  System.out.println("Both cards are " + card1.getRank());
                  System.out.println("This means war.");
                  
                  //start war pile
                  warPile.add(card1);
                  warPile.add(card2);
                  
                  boolean endWar = false;
                  while(!endWar){
                     //flip a card into the war pile
                     warPile.add(player1.getDeck().get(0));
                     warPile.add(player2.getDeck().get(0));
                     player1.removeCard();
                     player2.removeCard();      
                     
                     //flip a card and compare
                     card1 = player1.getDeck().get(0);
                     card2 = player2.getDeck().get(0);
                     player1.removeCard();
                     player2.removeCard();
                     if(card1.equals(card2)){ //Equal cards means war
                        System.out.println("Both cards are " + card1.getRank());
                        System.out.println("This means continued war.");
                     }
                     else if(card1.getRank() > card2.getRank()){
                         System.out.println("You win the war with a " + card1.toString() + " of " + card1.suitToString() + "!"); 
                         System.out.println("Player 2 had a " + card2.toString() + " of " + card2.suitToString() + "!"); 
                         for(int i = 0; i < warPile.size(); i++){
                           player1.addCard(warPile.get(0));
                           warPile.remove(0);
                         }
                         endWar = true;
                     }
                     else if(card2.getRank() > card1.getRank()){
                        System.out.println("Player 2 wins the war with a " + card2.toString() + " of " + card2.suitToString() + "!"); 
                        System.out.println("You had a " + card1.toString() + " of " + card1.suitToString() + "!"); 
                        for(int i = 0; i < warPile.size(); i++){
                           player2.addCard(warPile.get(0));
                           warPile.remove(0);
                        }
                        endWar = true;

                     }
                  }
                  endWar = false; //reinitialize
               
               }
               
               //player 1 wins round
               else if(card1.getRank() > card2.getRank()){
                  System.out.println("You win the round with a " + card1.toString() + " of " + card1.suitToString() + "!"); 
                  System.out.println("Player 2 lost with a " + card2.toString() + " of " + card2.suitToString() + "!"); 
                  player1.addCard(card1);
                  player1.addCard(card2);
               }
               //player 2 wins round
               else if(card2.getRank() > card1.getRank()){
                  System.out.println("Player 2 wins the round with a " + card2.toString() + " of " + card2.suitToString() + "!"); 
                  System.out.println("You had a " + card1.toString() + " of " + card1.suitToString() + "!"); 
                  player2.addCard(card1);
                  player2.addCard(card2);
               }
            }
            else{
               win = true;
            }
         }
         
         
         //Player doesn't want to continue playing
         if(input.equalsIgnoreCase("n")){
            System.out.println("Good Game.");
            System.exit(0);
         }
      }
      if(win){
         if(player1.getDeck().size() < 1){
            System.out.println("You lose :(");
            System.exit(0);
         
         }
         if(player2.getDeck().size() < 1){
            System.out.println("You win!");
            System.exit(0);
         }
      
      } 
   }     
} 
