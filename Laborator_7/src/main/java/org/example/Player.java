package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player implements Runnable {

    public static volatile boolean gameWon = false;
    private String name;
    private Bag bag;

    private int count = 0;

    private List<Token> tokens = new ArrayList<>();

    private List<Token> longestSequence = new ArrayList<>();

    public Player(String name, Bag bag) {
        this.name = name;
        this.bag = bag;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public List<Token> getLongestSequence() {
        return longestSequence;
    }

    private List<Token> checkPossiblePaths(Token token) {
        List<Token> possiblePaths = new ArrayList<>();
        for (Token nextToken : tokens) {
            if (nextToken == token) {
                continue;
            }
            if (nextToken.getFirst() == token.getSecond()) {
                possiblePaths.add(nextToken);
            }
        }
        return possiblePaths;
    }

    private boolean validateSequence(List<Token> tokenList) {
        if (tokenList.size() <= 1) {
            return false;
        }
        List<Integer> firstValues = new ArrayList<>();
        for (int i = 0; i < tokenList.size() - 1; i++) {
            firstValues.add(tokenList.get(i).getFirst());
            if (tokenList.get(i).getSecond() != tokenList.get(i + 1).getFirst()) {
                return false;
            }
            if (firstValues.contains(tokenList.get(i + 1).getFirst())) {
                return false;
            }
        }
        return true;
    }

    private void calculateLongestSequence() {
        for (Token startToken : tokens) {
            List<Token> sequence = new ArrayList<>();
            sequence.add(startToken);
            createPath(checkPossiblePaths(startToken), sequence);
        }
    }

    private void createPath(List<Token> possiblePaths, List<Token> sequence) {
        if (validateSequence(sequence)) {
            if (sequence instanceof LinkedList && !sequence.isEmpty() &&
                    ((LinkedList<Token>) sequence).getFirst().getFirst() ==
                            ((LinkedList<Token>) sequence).getLast().getSecond()) {
                if (sequence.size() > longestSequence.size()) {
                    longestSequence = new ArrayList<>(sequence);
                    this.count = sequence.size();
                }
            }
        }

        for (Token nextToken : possiblePaths) {
            List<Token> newSequence = new ArrayList<>(sequence);
            newSequence.add(nextToken);
            if (!validateSequence(newSequence)) {
                continue;
            }
            createPath(checkPossiblePaths(nextToken), newSequence);
        }
    }


    @Override
    public void run() {
        while (true) {
            if (gameWon || TimeKeeper.isTimeUp()) {
                synchronized (bag) {
                    bag.notifyAll();
                }
                break;
            }
            try {
                Token token = bag.getToken();
                if (token == null) {
                    gameWon = true;
                    break;
                }
                if (!gameWon && !TimeKeeper.isTimeUp()) {
                    tokens.add(token);
                    System.out.println(this.name + " caught " + token);
                }
                calculateLongestSequence();
                if (this.count == bag.getNumberN()) {
                    System.out.println(this.name + " won!");
                    System.out.println("He/She caught the longest sequence: " + longestSequence);
                    gameWon = true;
                    synchronized (bag) {
                        bag.notifyAll();
                    }
                    break;
                }
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
