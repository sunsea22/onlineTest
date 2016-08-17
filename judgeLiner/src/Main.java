import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(judge(input));
        }
        scanner.close();
    }

    public static String judge(String input) {
        String[] str = input.split(" ");
        StringBuilder res = new StringBuilder();
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        if (a*2 == b && a*3 == c) {
            res.append("YES");
            res.append(" ");
            res.append(a);
        }
        else {
            res.append("NO");
        }
        return res.toString();
    }
}
