import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            Float input = scanner.nextFloat();
            System.out.println(approximation(input));
        }
    }

    public static int approximation(Float input) {
        return (int) ((input * 10 + 5) / 10);

    }
}
