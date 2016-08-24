import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int num = scanner.nextInt();
            System.out.println(gcRation(str, num));
        }
    }

    private static String gcRation(String str, int num) {
        int[] k = new int[str.length()];
        int[] sum = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'C' || str.charAt(i) == 'G') {
                k[i]++;
            }
        }

        for (int i = 0; i < k.length - num; i++) {
            for (int j = 0; j < num; j++) {
                sum[i] += k[i+j];
            }
        }

        int max = 0;
        int idx = 0;

        for (int i = 0; i < k.length; i++) {
            if (sum[i] > max) {
                max = sum[i];
                idx = i;
            }
        }
        return str.substring(idx, idx + num);
    }
}
