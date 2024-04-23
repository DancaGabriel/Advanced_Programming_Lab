package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        while (n <= 2) {
            System.out.println("Give the max number that can appear on the tokens (must be >=3):");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
            n = scanner.nextInt();
        }
        System.out.println("Game started!");
        Bag bag = new Bag(n);
        Player player1 = new Player("Gabi", bag);
        Player player2 = new Player("Maria", bag);

        Thread thPlayer1 = new Thread(player1);
        Thread thPlayer2 = new Thread(player2);

        // TimeKeeper with 60 seconds time limit
        Thread timeKeeperThread = new Thread(new TimeKeeper(60000));
        timeKeeperThread.setDaemon(true);
        timeKeeperThread.start();

        thPlayer1.start();
        thPlayer2.start();

        thPlayer1.join();
        thPlayer2.join();

        System.out.println("Game over!");
        Thread.sleep(200);
        if (player1.getCount() != bag.getNumberN() && player2.getCount() != bag.getNumberN()) {
            System.out.println(player1.getName() + " has the tokens: " + player1.getTokens());
            System.out.println(player1.getName() +
                    " has a sequence of " + player1.getCount() + " tokens: "
                    + player1.getLongestSequence());
            System.out.println(player2.getName() + " has the tokens: " + player2.getTokens());
            System.out.println(player2.getName() +
                    " has a sequence of " + player2.getCount() + " tokens: "
                    + player2.getLongestSequence());
            if (player1.getCount() > player2.getCount()) {
                System.out.println(player1.getName() + " won!");
            } else if (player1.getCount() < player2.getCount()) {
                System.out.println(player2.getName() + " won!");
            } else {
                System.out.println("It's a draw!");
            }
        }
        else {
            System.out.println(player1.getName() + " has the tokens: " + player1.getTokens());
            System.out.println(player2.getName() + " has the tokens: " + player2.getTokens());
        }
    }
}