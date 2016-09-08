import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Sunsea on 16/8/12.
 */
public class    Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(count(input));
        }
        scanner.close();
    }

    public static int count(String input) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 0 && input.charAt(i) <= 127) {
                set.add(input.charAt(i));
            }
        }

        if (set.isEmpty()) return 0;
        else return set.size();
    }
}
