//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessingGameGUI {
    private static int randomNumber;
    private static int attemptsLeft = 5;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Guessing Game");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100");
        JTextField guessField = new JTextField();
        JTextArea resultArea = new JTextArea();
        JButton guessButton = new JButton("Submit Guess");
        JButton quitButton = new JButton("Quit");

        panel.add(instructionLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(resultArea);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(quitButton, BorderLayout.SOUTH);


        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String guessText = guessField.getText();


                quitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        resultArea.setText("You quit the game.");
                        System.exit(0);
                    }
                });

                frame.setVisible(true);
            }

            private static void handleGuess(int guess, JTextArea resultArea, JTextField guessField) {
                if (guess == randomNumber) {
                    resultArea.setText("Congratulations! You guessed the correct number!");
                    attemptsLeft = 0;
                } else if (guess < randomNumber) {
                    resultArea.setText("No, guess higher. Attempts left: " + (attemptsLeft - 1));
                } else if (guess > randomNumber) {
                    resultArea.setText("No, guess lower. Attempts left: " + (attemptsLeft - 1));
                }

                attemptsLeft--;
                if (attemptsLeft == 0) {
                    resultArea.append("Game Over! The number was " + randomNumber);
                }

                guessField.setText("");
            }
        }
  }