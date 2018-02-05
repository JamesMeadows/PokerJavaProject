/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author JamesMeadows18
 */
public class Poker {
    
    private Deck deck;
    public Poker(){
        deck = new Deck();
    }
    
    public Deck getDeck(){
        return deck;
    }
    
    public void drawCards(Player player){
        for (int i = 0; i < 5; i++){
            Card card = deck.getRandomCard();
            player.setCard(i, card);
        }
    }
    
     public void replaceCard(Player player, int index){
         Card card = deck.getRandomCard();
         player.setCard(index, card);
         System.out.println("You drew a " + card.getCardNumber() + " of " + card.getSuit());
     }
     
 
}
