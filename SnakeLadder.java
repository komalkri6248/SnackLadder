import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadder {
    public static void main(String[] args) {
        HashMap<Integer, Integer> snakes = new HashMap<>();
        HashMap<Integer, Integer> ladders = new HashMap<>();
        Random dice = new Random();
        Scanner sc = new Scanner(System.in);
        
        // Define some snakes
        snakes.put(99, 10);
        snakes.put(90, 20);
        snakes.put(70, 40);
        snakes.put(50, 30);
        snakes.put(25, 5);

        // Define some ladders
        ladders.put(3, 22);
        ladders.put(6, 25);
        ladders.put(20, 50);
        ladders.put(36, 55);
        ladders.put(63, 95);

        int position = 1; // Player starts from position 1
        
        System.out.println("Welcome to Snake and Ladder Game!");
        System.out.println("Press Enter to roll the dice.");

        while (position < 100) {
            sc.nextLine(); // Wait for user to press Enter
            int roll = dice.nextInt(6) + 1; // Rolling dice (1-6)
            System.out.println("You rolled: " + roll);

            int newPosition = position + roll;

            if (newPosition > 100) {
                System.out.println("You need an exact roll to reach 100. Try again!");
                continue;
            }

            // Check for snake or ladder
            if (snakes.containsKey(newPosition)) {
                System.out.println("Oops! A snake at " + newPosition + " takes you down to " + snakes.get(newPosition));
                newPosition = snakes.get(newPosition);
            } else if (ladders.containsKey(newPosition)) {
                System.out.println("Great! A ladder at " + newPosition + " takes you up to " + ladders.get(newPosition));
                newPosition = ladders.get(newPosition);
            }

            position = newPosition;
            System.out.println("Your new position: " + position);

            if (position == 100) {
                System.out.println("Congratulations! You won the game.");
                break;
            }
        }
        sc.close();
    }
}