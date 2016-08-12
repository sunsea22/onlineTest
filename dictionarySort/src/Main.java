import java.util.*;

/**
 * Created by Sunsea on 16/8/12.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            list.add(scanner.next());
        }

        Collections.sort(list);

        for (String str: list) {
            System.out.println(str);
        }
    }

}
