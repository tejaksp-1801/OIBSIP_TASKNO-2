import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        Random random = new Random();
        int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        int currentRound = 1;
        boolean continueGame = true;

        while (continueGame) {
            JOptionPane.showMessageDialog(null, "Round " + currentRound);
            int attemptsLeft = maxAttempts;

            while (attemptsLeft > 0) {
                String input = JOptionPane.showInputDialog(null, "Guess the number (between " + minRange + " and " + maxRange + ") - Attempts Left: " + attemptsLeft);
                if (input == null) {
                    // User clicked cancel, exit the game
                    continueGame = false;
                    break;
                }

                try {
                    int guess = Integer.parseInt(input);
                    attemptsLeft--;

                    if (guess == targetNumber) {
                        int roundScore = attemptsLeft + 1;
                        score += roundScore;
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number.\nRound Score: " + roundScore + "\nTotal Score: " + score);
                        break;
                    } else if (guess < targetNumber) {
                        JOptionPane.showMessageDialog(null, "Too low! Guess higher.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Too high! Guess lower.");
                    }

                    if (attemptsLeft == 0) {
                        JOptionPane.showMessageDialog(null, "Out of attempts! The number was: " + targetNumber);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                }
            }

            if (!continueGame) {
                JOptionPane.showMessageDialog(null, "Game over. Final Score: " + score);
                break;
            }

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Next Round", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Game over. Final Score: " + score);
                break;
            }

            targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            currentRound++;
        }
    }
}
