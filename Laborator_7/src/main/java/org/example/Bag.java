package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private int numberN;
    private List<Token> tokens = new ArrayList<>();

    public Bag(int numberTokens) {
        this.numberN = numberTokens;
        addTokens();
    }

    public int getNumberN() {
        return numberN;
    }

    private void addTokens() {
        for(int i = 1; i <= numberN; i++) {
            for(int j = i + 1; j <= numberN; j++) {
                tokens.add(new Token(i, j));
            }
        }
        for(int i = 1; i <= numberN; i++) {
            for (int j = i - 1; j > 0; j--) {
                tokens.add(new Token(i, j));
            }
        }
    }

    public synchronized Token getToken() throws InterruptedException{
        Random random = new Random();
        notifyAll();
        if (Player.gameWon || TimeKeeper.isTimeUp()) {
            return null;
        }
        wait();
        if (!tokens.isEmpty()) {
            int randomIndex = random.nextInt(tokens.size());
            Token token = tokens.get(randomIndex);
            tokens.remove(randomIndex);
            return token;
        }
        try {
            throw new GameEndException();
        }catch (GameEndException e) {
            notifyAll();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Bag{" +
                "tokens=" + tokens +
                '}';
    }
}