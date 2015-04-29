import java.io.*;
import javax.swing.*; 
import java.util.*;
import java.util.Collections;
/**
   @author Devin Walker
   4-29-2015
   CS110
   
   This class is a holder of an array list of cards. 
   There is also a sub-class called player, which is a player's hand. 
*/
public class Deck{
   
   private ArrayList<Card> deck; //field for holding stack of cards
  
  //constructor for players hand 
   public Deck(ArrayList<Card> someCards){
        deck = new ArrayList<Card>();

         for(int i = 0; i < someCards.size(); i++){
         deck.add(someCards.get(i));
      }
   }
   
   //construtor for deck
   public Deck(){ 
       deck = new ArrayList<Card>();
             
       for(int s = 0; s < 4; s++){
           for(int r = 2; r < 15; r++){
               Card newCard = new Card(s,r);
               this.deck.add(newCard);
           }
       }
   }
   
   //getter for deck
   public ArrayList<Card> getDeck(){
      return (this.deck);
   }
   
   //add card to deck
   public void addCard(Card card){
      deck.add(card);
   }
   
   //remove top card
   public void removeCard(){
      deck.remove(0);
   }
      
   //display the deck
   public void display(){
       System.out.println(deck);
   
   }
   
   //shuffle the deck
   public void shuffle(){
      Collections.shuffle(deck);
   }
   
}