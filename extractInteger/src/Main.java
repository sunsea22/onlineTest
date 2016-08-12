import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Sunsea on 16/8/12.
 * 类HashSet和LinkedHashSet都是接口Set的实现，两者都不能保存重复的数据。
 * HashSet不保证集合中元素的顺序，即不能保证迭代的顺序与插入的顺序一致。
 * LinkedHashSet按照元素插入的顺序进行迭代，即迭代输出的顺序与插入的顺序保持一致
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(extract(input));
        }
        scanner.close();
    }

    public static int extract(int input) {
        Set<Character> set = new LinkedHashSet<>();
        String tmp = String.valueOf(input);

        for (int i = tmp.length() - 1; i >= 0; i--) {
            set.add(tmp.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        for (char ch : set) {
            res.append(ch);
        }
        String result = "";
        if (res.toString().charAt(0) == '0') {
            result = res.toString().substring(1);
        }
        else result = res.toString();
        return Integer.valueOf(result);
    }
}
