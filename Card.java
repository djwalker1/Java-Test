/**
   @author Devin Walker
   2-18-2015
   CS110
   
   This class creates an object with a suit and a rank field.
   The object can not be manipulated after it's made.
   The user can use the provided get methods to see what the suit and rank are as a String.
   The user can also use the provided equals method to compare the ranks of 2 cards
*/

public class Card{
   //constant declarations
   public static final int SPADES = 0; //suits    
   public static final int HEARTS = 1;      
   public static final int DIAMONDS = 2;      
   public static final int CLUBS = 3;      
   public static final int JACK = 11;  //face cards
   public static final int QUEEN = 12;
   public static final int KING = 13;
   public static final int ACE = 14;
  
   private int suit; //field for holding a cards suit as an integer
   private int rank; //field for holding a cards rank (2-14)

   /**
      @param takes in a suit and rank
      @return nothing, is constructor
      This method makes a card with a specific suit and rank
   */   

   public Card(int suit, int rank){
      this.suit = suit;
      this.rank = rank;
   }

   /**
      This method gets the private field suit
      @param nothing
      @return suit
   */   
   public int getSuit(){
      return suit;
   }
   

   /**
      This method gets the private field rank
      @param nothing
      @return rank as an interger
   */   
   public int getRank(){
      return rank;
   }
   

      /**
      @param nothing
      @return a string with the rank converted (jack, queen, etc)
   */
   public String toString(){
      String rankName = null; //initialize a string to return
      
      //decide on rank name based on integer value in rank
      switch(rank){
         case JACK:
            rankName = "Jack"; 
            break;
         case QUEEN:
            rankName = "Queen";
            break;
         case KING:
            rankName = "King";
            break;
         case ACE:
            rankName = "Ace";
            break;
         default:
            rankName = Integer.toString(rank); //convert non-face cards to strings
            break;
      }
      return rankName;
   }

      /**
      @param nothing
      @return string of the suit
  
  */
   public String suitToString(){
      String suitName = null; //initialize
      
      //return a string with the name of the suit based on the integer value in the suit field
      switch(suit){
         case SPADES:
            suitName = "Spades"; 
            break;
         case DIAMONDS:
            suitName = "Diamonds";
            break;
         case CLUBS:
            suitName = "Clubs";
            break;
         case HEARTS:
            suitName = "Hearts";
            break;
         default:
            System.out.print("Error: Unknown Suit"); //error; this should not happen if suit is assigned correctly
            break;
      }
      return suitName;
   }
     
   /**
   this method compares the rank of another card instance to the current one.
   returns true if they are equal.
   @param a card to compare
   @return boolean if equal
   */
   public boolean equals(Card other){
      return (rank == other.rank);
   }   
}
