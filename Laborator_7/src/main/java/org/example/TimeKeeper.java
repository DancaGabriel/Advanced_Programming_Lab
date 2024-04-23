package org.example;

public class TimeKeeper implements Runnable {

    private final long timeLimit;
    private static volatile boolean timeUp = false;

    public TimeKeeper(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public synchronized static boolean isTimeUp() {
        return timeUp;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime > timeLimit) {
                timeUp = true;
                System.out.println("Time's up! " + elapsedTime / 1000 + " seconds have passed!");
                break;
            }
            if (Player.gameWon) {
                System.out.println("The game lasted " + elapsedTime / 1000 + " seconds.");
                break;
            }
        }
    }
}