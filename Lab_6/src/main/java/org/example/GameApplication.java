package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GameApplication extends JFrame {
    private JPanel configPanel;
    private DrawingPanel canvasPanel;
    private JPanel controlPanel;

    private static final String SAVE_FILE = "game_state.ser";

    public GameApplication() {
        setTitle("Game Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add components
        createConfigPanel();
        createCanvasPanel();
        createControlPanel();

        // Add panels to the frame
        add(configPanel, BorderLayout.NORTH);
        add(canvasPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Load game state if it exists
        loadGameState();

        setVisible(true);
    }

    private void createConfigPanel() {
        configPanel = new JPanel();

    }

    private void createCanvasPanel() {
        canvasPanel = new DrawingPanel(600, 300);
    }

    private void createControlPanel() {
        controlPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");
        JButton exportButton = new JButton("Export as PNG");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGameState();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "D:\\game_board.png";
                canvasPanel.exportBoardAsPNG(filePath);
            }
        });

        controlPanel.add(saveButton);
        controlPanel.add(exitButton);
        controlPanel.add(exportButton);
    }

    private void saveGameState() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(SAVE_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(canvasPanel);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Game state saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGameState() {
        File file = new File(SAVE_FILE);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(SAVE_FILE);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                canvasPanel = (DrawingPanel) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                System.out.println("Game state loaded.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameApplication();
            }
        });
    }
}
