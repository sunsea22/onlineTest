import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/13.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(qualified(input));
        }

        scanner.close();
    }

    public static String qualified(String input) {
        String res;
        if (input.length() > 8) {
            if (judgeSecond(input) && judgeSubStr(input))
                res = "OK";
            else
                res = "NG";
        }
        else res = "NG";
        return res;
    }

    public static boolean judgeSecond(String input) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') count1 = 1;
            else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') count2 = 1;
            else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') count3 = 1;
            else count4 = 1;
        }
        if (count1 + count2 + count3 + count4 < 3) return false;
        else return true;
    }

    public static boolean judgeSubStr(String input) {
        String subStr1;
        String subStr2;
        int count = 0;

        for (int i = 0; i < input.length() - 3; i++) {
            subStr1 = input.substring(i,i+3);

            for (int j = i+3; j < input.length() - 2; j++) {
                subStr2 = input.substring(j,j+3);
                if (subStr1.equals(subStr2))
                    count ++;
            }
        }
        if (count != 0)
            return false;
        else
            return true;
    }
}
