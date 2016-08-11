import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(hexToDec(s));
        }
        scanner.close();
    }

    public static int hexToDec(String hex) {
        final int flag = 16;
        int res = 0;

        for (int i = 2; i < hex.length(); i++) {
            res = res * flag + hexToNum(hex.charAt(i));
        }
        return res;
    }

    public static int hexToNum(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        }
        else if (ch >= 'a' && ch <= 'z') {
            return ch - 'a' + 10;
        }
        else {
            return ch - 'A' + 10;
        }
    }

}
