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
    private int score;
    private String name;
    
    public Player(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public String getType(){
        return "player";
    }
    
    public void setCard(int index, Card card){
        cards[index] = card;
    }
    
    public Card[] getHand(){
        return cards;
    }
    
    public void setScore(int i){
        score = i;
    }
    
    public int getScore(){
        return score;
    }
}
