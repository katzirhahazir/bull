package poar;
import java.util.Scanner;
public class threetothree {
    public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

        String secretNumber = generateSecretNumber();
        int guessCount = 0;

        System.out.println("Welcome to Bulls and Cows game!");
        System.out.println("Try to guess a 4-digit secret number.");
        System.out.println("For every digit that you guessed correctly in the right place, you have a bull.");
        System.out.println("For every digit that you guessed correctly in the wrong place, you have a cow.");

        while (true) {
            System.out.print("Enter your guess (4 digits): ");
            String guess = input.nextLine();

            if (!isValidGuess(guess)) {
                System.out.println("Invalid guess! Please enter 4 digits.");
                continue;
            }

            guessCount++;

            int bulls = 0;
            int cows = 0;

            for (int i = 0; i < secretNumber.length(); i++) {
                char secretChar = secretNumber.charAt(i);
                char guessChar = guess.charAt(i);

                if (secretChar == guessChar) {
                    bulls++;
                } else if (secretNumber.contains(String.valueOf(guessChar))) {
                    cows++;
                }
            }

            System.out.printf("You have %d in the right place and %d that are right but  not in their place.\n", bulls, cows);

            if (bulls == 4) {
                System.out.printf("Congratulations! You guessed the secret number in %d attempts.\n", guessCount);
                break;
            }
        }
    }

    private static String generateSecretNumber() {
        StringBuilder sb = new StringBuilder();
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < 4; i++) {
            int randomIndex = (int) (Math.random() * (10 - i));
            sb.append(digits[randomIndex]);
            digits[randomIndex] = digits[9 - i];
        }

        return sb.toString();
    }

    private static boolean isValidGuess(String guess) {
        if (guess.length() != 4) {
            return false;
        }

        for (char c : guess.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}