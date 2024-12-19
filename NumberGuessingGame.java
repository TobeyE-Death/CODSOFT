import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private static final int MAX_TRIES = 10;

    public static void startNewRound() {
        Random random = new Random();
        int min = 1, max = 100;
        int secretNumber = random.nextInt(max - min + 1) + min;
        int userGuess, attemptCount = 0;
        
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + min + " and " + max + ".");

        while (true) {
            System.out.print("Your guess: ");
            userGuess = input.nextInt();
            attemptCount++;

            if (userGuess < secretNumber) {
                System.out.println("Too low.");
            } else if (userGuess > secretNumber) {
                System.out.println("Too high.");
            } else {
                System.out.println("Correct! You guessed the number.");
                break;
            }

            if (attemptCount == MAX_TRIES) {
                System.out.println("Out of attempts! The correct number was " + secretNumber + ".");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int playAgain;

        do {
            startNewRound();

            System.out.print("Play again? (1 = Yes, 0 = No): ");
            playAgain = input.nextInt();
        } while (playAgain == 1);

        System.out.println("Thanks for playing!");
    }
}