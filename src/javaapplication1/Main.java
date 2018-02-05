/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author JamesMeadows18
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.getDeck().shuffleDeck();

        Player player = new Player("Player1");
        poker.drawCards(player);

        Computer computer = new Computer();
        poker.drawCards(computer);

        System.out.println("Current Hand");
        printHand(player);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the card indexes you want to re-draw seperated by a comma. For example 1, or 1,3");
        boolean repick = false;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("fold")) {
                System.out.println("You lost the round");
                computer.setScore(computer.getScore() + 1);
            } else if (line.equals("call")) {
                int playerValue = calculateHandValue(player);
                int computerValue = calculateHandValue(computer);
                System.out.println("Computer's hand: ");
                printHand(computer);
                System.out.println("");
                System.out.println("Your card value: " + playerValue);
                System.out.println("Computer card value: " + computerValue);

                if (playerValue > computerValue) {
                    System.out.println("You won the round");
                    player.setScore(player.getScore() + 1);
                } else if (playerValue == computerValue) {
                    System.out.println("You Tied the round");

                } else {
                    System.out.println("You Lost the round");
                    computer.setScore(computer.getScore() + 1);
                }
                return;
            } else if (line.contains(",")) {
                if (repick) {
                    System.out.println("Cannot redraw your cards again");
                    continue;
                }
                repick = true;
                String[] read = line.split(",");
                for (String num : read) {
                    int index = Integer.valueOf(num);
                    if (index < 0 || index > 4) {
                        System.out.println("number must be between 0 and 4");
                        continue;
                    }
                    poker.replaceCard(player, index);
                }
                System.out.println("Final Hand");
                printHand(player);
            }
        }
    }

    public static void printHand(Player player) {
        for (int i = 0; i < 5; i++) {
            Card card = player.getHand()[i];
            System.out.println("#" + i + ": " + card.getCardNumber() + " of " + card.getSuit());
        }
    }

    public static int calculateHandValue(Player player) {
        Card[] hand = player.getHand();
        //check flush 
        for (int i = 0; i < 4; i++) {
            int amount = 0;
            for (Card card : hand) {
                if (card.getSuit().equals(Card.convertSuit(i))) {
                    amount++;
                }
            }
            if (amount == 5) {
                return 61;
            }
        }

        //check straight
        //coming soon
        
        //check highest card, pairs, tripples, quads
        int highestGrouping = 0;
        int highestGroupingValue = 0;
        for (int i = 1; i < 14; i++) {
            int amount = 0;
            for (Card card : hand) {
                if (card.getCardNumber() == i) {
                    amount++;
                }
            }
            if (amount > highestGrouping) {
                highestGrouping = amount;
                highestGroupingValue = i;
            } else if (amount == highestGrouping && i > highestGroupingValue) {
                highestGroupingValue = i;
            }
        }
        return (highestGrouping - 1) * 15 + highestGroupingValue;
    }

}
