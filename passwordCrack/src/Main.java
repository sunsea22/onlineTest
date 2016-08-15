import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(crack(input));
        }
        scanner.close();
    }

    public static String crack(String input) {
        char[] str = input.toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (str[i] >= 'a' && str[i] <= 'z') {
                str[i] = lowerCase(str[i]);
            }
            if (str[i] >= 'A' && str[i] <= 'Y') {
                String tmp = String.valueOf(str[i]).toLowerCase();
                str[i] = (char)(Integer.valueOf(tmp.charAt(0)) + 1);
            }
            if (str[i] == 'Z') {
                str[i] = 'a';
            }
        }
        String res = "";
        for (char ch: str) {
            res += ch;
        }
        return res;
    }

    public static char lowerCase(char ch) {
        if (ch >= 'a' && ch <= 'c') return '2';
        if (ch >= 'd' && ch <= 'f') return '3';
        if (ch >= 'g' && ch <= 'i') return '4';
        if (ch >= 'j' && ch <= 'l') return '5';
        if (ch >= 'm' && ch <= 'o') return '6';
        if (ch >= 'p' && ch <= 's') return '7';
        if (ch >= 't' && ch <= 'v') return '8';
        else return '9';
    }
}
