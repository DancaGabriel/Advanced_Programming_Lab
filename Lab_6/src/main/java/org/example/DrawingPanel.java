package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;


public class DrawingPanel extends JPanel implements Serializable {
    private int gridSize = 50; // Default grid size
    private boolean[][] sticks; // Array to store stick positions
    private Color currentPlayerColor = Color.RED; // Red starts
    private int stoneSize = 10; // Size of stones
    private boolean gameOver = false;

    public DrawingPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        initializeSticks(width, height);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!gameOver) {
                    int x = e.getX() / gridSize;
                    int y = e.getY() / gridSize;
                    if (isValidMove(x, y)) {
                        placeStone(x, y);
                        togglePlayer();
                        repaint();
                        if (checkForWin()) {
                            gameOver = true;
                            JOptionPane.showMessageDialog(null, "Player " + (currentPlayerColor == Color.RED ? "Red" : "Blue") + " wins!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid move!");
                    }
                }
            }
        });
    }

    private void initializeSticks(int width, int height) {
        int columns = width / gridSize;
        int rows = height / gridSize;
        sticks = new boolean[rows][columns];
        Random random = new Random();
        // Randomly place sticks on the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sticks[i][j] = random.nextBoolean();
            }
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < sticks[0].length && y >= 0 && y < sticks.length && !sticks[y][x];
    }

    private void placeStone(int x, int y) {
        sticks[y][x] = true;
    }

    private void togglePlayer() {
        currentPlayerColor = (currentPlayerColor == Color.RED) ? Color.BLUE : Color.RED;
    }

    private boolean checkForWin() {
        // Implement your logic to check for a win condition
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        // Draw grid lines based on grid size
        g.setColor(Color.BLACK);
        for (int x = 0; x <= width; x += gridSize) {
            g.drawLine(x, 0, x, height);
        }
        for (int y = 0; y <= height; y += gridSize) {
            g.drawLine(0, y, width, y);
        }

        // Draw sticks
        g.setColor(Color.BLACK);
        for (int i = 0; i < sticks.length; i++) {
            for (int j = 0; j < sticks[i].length; j++) {
                if (sticks[i][j]) {
                    g.fillRect(j * gridSize, i * gridSize, gridSize, gridSize);
                }
            }
        }

        // Draw stones
        g.setColor(currentPlayerColor);
        if (!gameOver) {
            Point mousePosition = getMousePosition();
            if (mousePosition != null) {
                int x = (mousePosition.x / gridSize) * gridSize + (gridSize - stoneSize) / 2;
                int y = (mousePosition.y / gridSize) * gridSize + (gridSize - stoneSize) / 2;
                g.fillOval(x, y, stoneSize, stoneSize);
            }
        }
    }

    public void exportBoardAsPNG(String filePath) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        paint(g2d);
        g2d.dispose();
        try {
            ImageIO.write(image, "PNG", new File(filePath));
            System.out.println("Board exported as PNG: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
