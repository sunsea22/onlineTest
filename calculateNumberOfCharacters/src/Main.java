import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/11.
 * next方法不能得到带空格的字符串。
 * nextLine()方法的结束符只是Enter键，即nextLine()方法返回的是Enter键之前的所有字符，它是可以得到带空格的字符串的
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char ch = scanner.nextLine().charAt(0);
            System.out.println(countNumber(input,ch));
        }
        scanner.close();
    }

    public static int countNumber(String input, char ch) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.toUpperCase(ch) == input.charAt(i) || Character.toLowerCase(ch) == input.charAt(i))
                count++;
        }
        return count;
    }

}
