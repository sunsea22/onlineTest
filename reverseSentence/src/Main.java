import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            reverse(input);
        }
    }

    public static void reverse(String input) {
        String[] tmp = input.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = tmp.length - 1; i >= 0; i--) {
            res.append(" " + tmp[i]);
        }
        System.out.println(res.toString().trim());
    }
}
