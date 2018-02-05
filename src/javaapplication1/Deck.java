/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author JamesMeadows18
 */
public class Deck {
    
    
    private final ArrayList<Card> cards = new ArrayList();
   
    public Deck(){
      
    }
    
    public void shuffleDeck(){
        this.cards.clear();
        for (int i = 1; i < 14; i++){
          for (int j = 0; j < 4; j++){
             Card card = new Card(Card.convertSuit(j),i);
             this.addCard(card);
            ///  System.out.println(card.getCardNumber() + " " + card.getSuit());
          }  
        }  
    }
    
    Random random = new Random();
    public Card getRandomCard(){
        Card card = cards.get(random.nextInt(cards.size()));
        cards.remove(card);
        return card;
    }
    
    private void addCard(Card card){
        this.cards.add(card);
    }
    
    public ArrayList<Card> getCards(){
        return cards;
    }
 
}
