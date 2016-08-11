import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(findLastWordLength(input));
        }
    }

    public static int findLastWordLength(String input) {
        //最后一个字母的位置
        int last = input.length() - 1;

        //找最后一个字母出现的位置
        while (last >= 0 && input.charAt(last) == ' ') {
            last--;
        }

        //找最后一个字母之前的第一个空格
        int pos = last - 1;
        while (pos >= 0 && input.charAt(pos) != ' ') {
            pos--;
        }
        return last - pos;
    }
}
