
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 5;

        Scanner scanner = new Scanner(System.in);
        System.out.println("____________________");
        System.out.println();
        System.out.println("NEW GAME");
        System.out.println("____________________");
        System.out.println();
        System.out.println();

        System.out.println("Pick a number between 1-100! You will get 5 turns");
        int low=0,high=100;
        while (true) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            System.out.println("player guesses "+guess);

            numberOfTries--;
            if(numberOfTries>0)
            {
                if (guess < numberToGuess) {
                    System.out.println("Sorry, that is too low");
                    low=guess;
                    System.out.println("pick a number between "+(guess+1)+"-"+high+" and turns left "+numberOfTries);
                } else if (guess > numberToGuess) {
                    System.out.println("Sorry, that number is too high!");
                    high=guess;
                    System.out.println("pick a number between "+low+"-"+(guess-1)+" and turns left "+numberOfTries);
                } else if(guess == numberToGuess){
                    System.out.println("player guesses "+numberToGuess);
                    System.out.println("YOU WIN! The SECRET number was "+numberToGuess );
                    break;
                }
            }
        }
    }
}
