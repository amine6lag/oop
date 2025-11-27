package oop;
import java.util.LinkedList;

public class Player {
     private String name;
     private LinkedList<Card> hand;
	 
     public Player(String name) {
		this.name = name;
	 }
     public void addToHand(Card c) {
    	 hand.add(c);
     }
    

}
