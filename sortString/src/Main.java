import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(convert(input));
        }
        scanner.close();
    }

    public static String convert(String input) {
        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
                tmp.append(input.charAt(i));
            }
        }

        String str = tmp.toString();
        char[] str1 = str.toCharArray();
        char[] strTmp = str.toLowerCase().toCharArray();

        for (int i = 0; i < strTmp.length; i++) {
            for (int j = 0; j < strTmp.length - i - 1; j++) {
                if (strTmp[j] > strTmp[j+1]) {
                    char temp = strTmp[j];
                    strTmp[j] = strTmp[j+1];
                    strTmp[j+1] = temp;

                    char temp1 = str1[j];
                    str1[j] = str1[j+1];
                    str1[j+1] = temp1;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int flag = 0;

        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') && !(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
                res.append(input.charAt(i));
            }
            else {
                res.append(str1[flag]);
                flag++;
            }
        }
        return res.toString();
    }
}
