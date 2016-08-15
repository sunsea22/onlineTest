import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        while (scanner.hasNextInt() && (num = scanner.nextInt()) != 0) {
            System.out.println(changeNumber(num));
            System.out.println(secondWay(num));
        }
        scanner.close();
    }

    public static int changeNumber(int input) {
        if (input <= 1) return 0;
        if (input == 2) return 1;
        int quotient = input / 3;
        int remainder = input % 3;
        int count = 0;
        int flag = 0;

        while (quotient > 0) {
            count += quotient;
            flag += quotient % 3;
            quotient = quotient / 3;
        }
        return count + changeNumber(flag+remainder);
    }

    public static int secondWay(int input) {
        int a,b; //a表示n-1次喝到的汽水瓶总数，b表示最终剩余的瓶子数目
        if (input == 2) {
            a = 1;
            b = 0;
            return a+b;
        }
        else {
            if (input % 2 == 0) {
                b = 1;
                a = secondWay(input - 1);
                return a + b;
            }
            else {
                b = 0;
                a = secondWay(input - 1);
                return a + b;
            }
        }
    }
}
