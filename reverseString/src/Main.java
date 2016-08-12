import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(reverse(input));
        }
        scanner.close();
    }

    public static String reverse(String input) {
        StringBuilder res = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            res.append(input.charAt(i));
        }
        return res.toString();
    }
}
