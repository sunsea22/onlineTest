import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/15.
 */
public class Main {
    //String[] lowCase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    //String[] upperCase = {"A","B","C","D","E","F","G","H","I",}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(code(input));
            input = scanner.nextLine();
            System.out.println(deCode(input));
        }
    }

    public static String code(String input) {
        char[] ch = input.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '9') ch[i] = '0';
            else if (ch[i] >= '0' && ch[i] <= '8') ch[i] += 1;
            else if (ch[i] == 'z') ch[i] = 'A';
            else if (ch[i] == 'Z') ch[i] = 'a';
            else if (ch[i] >= 'a' && ch[i] <= 'y') {
                String tmp = ("" + ch[i]).toUpperCase();
                ch[i] = (char)(tmp.charAt(0) + 1);
            }
            else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                String tmp = ("" + ch[i]).toLowerCase();
                ch[i] = (char)(tmp.charAt(0) + 1);
            }
            else {

            }
        }
        StringBuilder res = new StringBuilder();

        for (char c: ch) {
            res.append(c);
        }
        return res.toString();
    }

    public static String deCode(String input) {
        char[] ch = input.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0') ch[i] = '9';
            else if (ch[i] >= '1' && ch[i] <= '9') ch[i] -= 1;
            else if (ch[i] == 'a') ch[i] = 'Z';
            else if (ch[i] == 'A') ch[i] = 'z';
            else if (ch[i] >= 'b' && ch[i] <= 'z') {
                String tmp = ("" + ch[i]).toUpperCase();
                ch[i] = (char)(tmp.charAt(0) - 1);
            }
            else if (ch[i] >= 'B' && ch[i] <= 'Z') {
                String tmp = ("" + ch[i]).toLowerCase();
                ch[i] = (char)(tmp.charAt(0) - 1);
            }
            else {

            }
        }
        StringBuilder res = new StringBuilder();

        for (char c: ch) {
            res.append(c);
        }
        return res.toString();
    }
}
