import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(delete(input));
        }
        scanner.close();
    }

    public static String delete(String input) {
        int[] times = new int[26];

        for (int i = 0; i < input.length(); i++) {
            times[input.charAt(i) - 'a']++;
        }


        /**
         * 找出最少的次数
         */
        int min = 20;
        for (int i = 0; i < times.length; i++) {
            if (min > times[i] && times[i] != 0) {
                min = times[i];
            }
        }

        /**
         * 记录最少次数的位置
         */
        List record = new ArrayList();
        for (int i = 0; i < times.length; i++) {
            if (times[i] == min)
                record.add(i);
        }

        StringBuilder res = new StringBuilder();
        String tmp = "";

        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        for (int i = 0; i < record.size(); i++) {
            tmp += letters[(int)record.get(i)];
        }

        for (int i = 0; i < input.length(); i++) {
            if (!tmp.contains("" + input.charAt(i))) {
                res.append(input.charAt(i));
            }
        }
        return res.toString();
    }
}
