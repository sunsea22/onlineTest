import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String[] str = new String[3];
            for (int i = 0; i < 3; i++) {
                str[i] = scanner.nextLine();
            }
            System.out.println(bestCoord(str));
        }
        scanner.close();
    }

    private static String bestCoord(String[] str) {
        DecimalFormat digital = new DecimalFormat("0.000000");
        String[] str1 = str[0].split(" ");
        String[] str2 = str[1].split(" ");
        String[] str3 = str[2].split(" ");

        double x1 = Double.parseDouble(str1[0]);
        double y1 = Double.parseDouble(str1[1]);
        double r1 = Double.parseDouble(str1[2]);

        double x2 = Double.parseDouble(str2[0]);
        double y2 = Double.parseDouble(str2[1]);
        double r2 = Double.parseDouble(str2[2]);

        double x3 = Double.parseDouble(str3[0]);
        double y3 = Double.parseDouble(str3[1]);
        double r3 = Double.parseDouble(str3[2]);


        double x, y;
        String res = "";
        for (x = -1000; x <= 1000; x++) {
            for (y = -1000; y <= 1000; y++) {
                if (((x - x1)*(x-x1) + (y-y1)*(y-y1))/r1*r1 == ((x-x2)*(x-x2) + (y-y2)*(y-y2))/r2*r2) {
                    if (((x - x1)*(x-x1) + (y-y1)*(y-y1))/r1*r1 == ((x-x3)*(x-x3) + (y-y3)*(y-y3))/r3*r3) {
                        res += digital.format(x) + " " + digital.format(y);
                    }
                }
            }
        }
        if (res.equals(""))
            return "NO";
        return res;
    }
}
