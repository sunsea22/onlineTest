import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> hasMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int keys = scanner.nextInt();
            int values = scanner.nextInt();
            int temp = 0;
            if (hasMap.containsKey(keys)) {
                temp = hasMap.get(keys) + values;
                hasMap.put(keys,temp);
            }
            else {
                hasMap.put(keys,values);
            }
        }

        for (Integer key: hasMap.keySet()) {
            System.out.println(key + " " + hasMap.get(key));
        }
        scanner.close();
    }


}
