package oop;
import java.util.Stack;

import oop.Card.Color;

import java.util.Collections;



public class Deck {

	private Stack<Card> deck;
	
	
    public Deck() {
    	deck = new Stack<>();
    	build();
    	shuffling();
    }
    
    
    public void shuffling() {
    	Collections.shuffle(deck);
    }
    
    

    public void drawing(Player p) {
    		for(int i = 0; i <= 7;i++) {
    			p.addToHand(deck.pop());
    		}
   
    }
    
    
    public void build() {
    	for (Color c : Color.values()) {
            if (c == Color.Joker) continue;

            // Cartes 0 à 9
            for (int i = 0; i <= 9; i++) {
                deck.push(new NumberCard(c, i));
                if (i != 0) 
                	deck.push(new NumberCard(c, i)); // les cartes 1–9 sont doublées
            }

            // Skip x2
            deck.push(new SkipCard(c));
            deck.push(new SkipCard(c));

            // Reverse x2
            deck.push(new ReverseCard(c));
            deck.push(new ReverseCard(c));

            // +2 x2
            deck.push(new DrawTwoCard(c));
            deck.push(new DrawTwoCard(c));
        }

        // Jokers
        for (int i = 0; i < 4; i++) {
            deck.push(new WildCard());
            deck.push(new WildFourCard());
        }
    }
    
    
    public Card pop() {
    	return deck.pop();
    }
    
    
    public int size() {
    	return deck.size();
    }
    
    
    public void push(Card c) {
    	deck.push(c);
    }
}
