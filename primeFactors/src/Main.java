import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            long input = scanner.nextLong();
            System.out.println(findPrime(input));
        }

        scanner.close();
    }

    public static String findPrime(long input) {
        StringBuilder builder = new StringBuilder();
        long i = 2;

        while (i <= input) {
            // 每次的i一定是质数时才会满足
            // 因为如果是一个合数，那那它一定是由更小的质数相乘得来的，
            // 而在i前的质数已经全部被使用过了，不能再整除num了
            while (input % i == 0) {
                builder.append(i).append(' ');
                input /= i;
            }
            i++;
        }
        return builder.toString();
    }
}
