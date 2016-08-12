import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(reverse(input));
        }

        scanner.close();
    }

    public static String reverse(int input) {
        String tmp = String.valueOf(input);
        StringBuilder res = new StringBuilder();

        for (int i = tmp.length() - 1; i >= 0; i--) {
            res.append(tmp.charAt(i));
        }
        return res.toString();
    }
}
