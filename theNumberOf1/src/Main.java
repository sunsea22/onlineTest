import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/13.
 * 无符号右移赋值操作 (>>>=)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(transfer(input));
        }

        scanner.close();
    }

    public static int transfer(int input) {
        int count = 0;
        while (input != 0) {
            count += input & 1;
            input >>>= 1;
        }
        return count;
    }
}
