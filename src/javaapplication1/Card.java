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
public class Card {
    private String suit;
    private int number;
    
    public Card(String suit, int number){
        this.number = number;
        this.suit = suit;
    }
    
    public static String convertSuit(int suit){
        if (suit == 0){
            return "spades";
        }
        else if (suit == 1){
            return "clubs";
        }
        else if (suit == 2){
            return "hearts";
        }
        else if (suit == 3){
            return "diamonds";
        }
        else return null;
    }
    
    public String getSuit(){
        return suit;
    }
    
    public int getCardNumber(){
        return number;
    }
}
