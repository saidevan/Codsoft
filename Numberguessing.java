import java.util.Scanner;

public class Numberguessing {
    public static void main(String[] args) {
        int score = 0;
        System.out.println("Let's play a game. I'll pick a number between");
        System.out.println("1 and 100, and you try to guess it.");
        Scanner sc1 = new Scanner(System.in);

        while (true) {
            score += playGame(sc1);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc1.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over! Your total score is: " + score);
        sc1.close();
    }

    static int playGame(Scanner sc) {
        int computersNumber;
        int usersGuess;
        int guessCount = 0;
        int gameScore = 0;

        computersNumber = (int) (100 * Math.random()) + 1;

        System.out.println();
        System.out.println("What is your first guess?");

        while (true) {
            usersGuess = sc.nextInt();
            guessCount++;

            if (usersGuess == computersNumber) {
                System.out.println("You got it in " + guessCount + " guesses! My number was " + computersNumber);
                // Add points to the score based on the number of guesses
                gameScore = 10 - guessCount; // For example: Less guesses, higher score
                if (gameScore < 0) {
                    gameScore = 0; // Score should not be negative
                }
                break;
            }

            if (guessCount == 6) {
                System.out.println("You didn't get the number in 6 guesses.");
                System.out.println("You lose. My number was " + computersNumber);
                break;
            }

            if (usersGuess < computersNumber) {
                System.out.println("Your number is too low. Try again:");
            } else if (usersGuess > computersNumber) {
                System.out.println("Your number is too high. Try again:");
            }
        }

        System.out.println();
        return gameScore;
    }
}
