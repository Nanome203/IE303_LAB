import java.util.Random;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int n = 0, input_number = 0;
        int[] range = new int[2];
        range[0] = 0;
        System.out.println("GUESS THE NUMBER GAME");
        do {
            System.out.print("\nEnter n (n>1): ");
            n = scanner.nextInt();
        } while (n <= 1);
        int randomNumber = rand.nextInt(1, n);
        range[1] = n;
        while (input_number != randomNumber) {
            System.out.println("\n(" + range[0] + "," + range[1] + ")");
            System.out.print("Choose your number: ");
            input_number = scanner.nextInt();
            if (input_number > range[1] || input_number < range[0])
                System.out.println("Out of range");
            else if (input_number > randomNumber) {
                System.out.println("Too high");
                range[1] = input_number - 1;
            } else if (input_number < randomNumber) {
                System.out.println("Too low");
                range[0] = input_number + 1;
            } else if (range[0] == range[1]) {
                System.out.println("You lost");
                break;
            } else {
                System.err.println("You are correct");
            }

        }
        scanner.close();
    }

}
