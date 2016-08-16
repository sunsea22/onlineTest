import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/16.
 * 这道题字母除了a-f，还有其它字符
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(merge(str1,str2));
        }
    }

    public static String merge(String str1, String str2) {
        String str = str1 + str2;
        StringBuilder str1Tmp = new StringBuilder();
        StringBuilder str2Tmp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) str1Tmp.append(str.charAt(i));
            else str2Tmp.append(str.charAt(i));
        }

        String a = sort(str1Tmp.toString());
        String b = sort(str2Tmp.toString());

        StringBuilder fin = new StringBuilder();
        int k = 0;
        int m = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                fin.append(a.charAt(k));
                k++;
            }
            else {
                fin.append(b.charAt(m));
                m++;
            }
        }

        String res = fin.toString();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < res.length(); i++) {
            result.append(convert(res.charAt(i)));
        }

        return result.toString();

    }

    public static String sort(String str) {
        char[] ch = str.toCharArray();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length - i - 1; j++) {
                if (ch[j] > ch[j+1]) {
                    char tmp = ch[j];
                    ch[j] = ch[j+1];
                    ch[j+1] = tmp;
                }
            }
        }

        for (char s: ch) {
            res.append(s);
        }
        return res.toString();
    }

    public static char convert(char ch) {
        char[] mask = {'0', '8', '4', 'C', '2', 'A', '6', 'E', '1', '9', '5', 'D', '3', 'B', '7', 'F'};
        if (ch >= '0' && ch <= '9') {
            return mask[ch - '0'];
        }
        else if (ch >= 'a' && ch <= 'f') {
            return mask[ch - 'a' + 10];
        }
        else if (ch >= 'A' && ch <= 'F') {
            return mask[ch - 'A' + 10];
        }
        return ch;
    }
}
