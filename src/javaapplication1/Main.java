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
        Player player = new Player();
        poker.drawCards(player);
        System.out.println("Current Hand");
        printHand(player);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the card indexes you want to re-draw seperated by a comma");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("fold")){
                System.out.println("You lost the round");
            }
            else if (line.contains(",")) {
                String[] read = scanner.nextLine().split(",");
                for (String num : read) {
                    int index = Integer.valueOf(num);
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

}
