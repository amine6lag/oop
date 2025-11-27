package oop;
import java.util.LinkedList;
import java.util.Stack;
import oop.Card.Color;

public class Game {
	private Deck gamedeck;
	private LinkedList<Player> players;
	private Stack<Card> playedCards;
	private int direction; //-1 et 1 
	
	
	
	public LinkedList<Player> getPlayers() {
		return players;
	}
	
	
	public Stack<Card> getPlayedCards() {
		return playedCards;
	}
	
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
	public void rebuild(Deck deck) {
 	    if (playedCards.isEmpty()) return;

 	    // On garde la dernière carte jouée (visible sur la table)
 	    Card top = playedCards.pop();

 	    // Remettre toutes les anciennes cartes dans le deck
 	    while (!playedCards.isEmpty()) {
 	        deck.push(playedCards.pop());
 	    }

 	    // Mélange du deck
 	    deck.shuffling();

 	    // Remettre la dernière carte jouée dans la défausse (toujours visible)
 	    playedCards.push(top);
 	}
	
	
	
	public Card drawCard(Deck deck) {
   	    if (deck.size() <= 6) {
   	        rebuild(deck);
   	    }
   	    return deck.pop();
   	}
	
	
	
	public Card.Color getCurrentColor(Card card) {
		return card.getColor();
	}
	
	
	
	public boolean canPlay(Card played, Card top) {
	    return played.getColor() == top.getColor()
	        || played.getValue().equals(top.getValue())
	        || played.getColor() == Color.WILD; 
	}
	
	
	
	public boolean checkApplyCard(Card played, Player player) {
    Card top = playedCards.peek(); // carte sur la table

	
	    // 1. Vérifier si on peut jouer cette carte
	    if (!canPlay(played, top)) {
	        System.out.println("Carte illégale : " + played);
	        return false;
	    }

	    // 2. Poser la carte
	    playedCards.push(played);

	    String val = played.getValue();

	    // 3. Appliquer les effets
	    switch (val) {

	        case "Skip":
	            skipNextPlayer();
	            break;

	        case "Reverse":
	            reverseDirection();
	            break;

	        case "+2":
	            makeNextPlayerDraw(2);
	            nextTurn();
	            break;

	        case "Wild":
	            Color chosen = player.chooseColor(); // méthode que le joueur doit implémenter
	            played.setColor(chosen);
	            break;

	        case "+4":
	            Color chosen2 = player.chooseColor();
	            played.setColor(chosen2);
	            makeNextPlayerDraw(4);
	            nextTurn();
	            break;

	        default:
	            // Carte normale (0–9), aucun effet
	            break;
	    }

	    return true;
	}
	
	
	
	public void nextTurn() {
		
	}

	
}
