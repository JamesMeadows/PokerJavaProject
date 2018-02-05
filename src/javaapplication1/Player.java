/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author JamesMeadows18
 */
public class Player {
    private Card[] cards = new Card[5];
    
    public void setCard(int index, Card card){
        cards[index] = card;
    }
    
    public Card[] getHand(){
        return cards;
    }
}
