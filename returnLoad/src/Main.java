import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(loadReturn(input));
        }
        scanner.close();
    }

    public static String loadReturn(String input) {
        DecimalFormat digits = new DecimalFormat("0.00");
        String[] tmp = input.split(" ");
        Double principal = Double.valueOf(tmp[0]) * 10000;
        int years = Integer.parseInt(tmp[1])*12;
        Double rate = Double.valueOf(tmp[2])*0.01 / 12;
        Double monthMoney = Double.valueOf(digits.format((principal * rate * Math.pow(1 + rate, years)) / (Math.pow(1 + rate, years) - 1)));

        Double a = 0.0; //本金
        Double b = 0.00000001; //利息
        int count = 0;
        while (a < b && years > 0) {
            if (years > 1) {
                a = Double.valueOf(digits.format(monthMoney - principal * rate));
                b = Double.valueOf(digits.format(principal * rate));
                principal = Double.valueOf(digits.format(principal - a));
            }
            else {
                a = principal;
                b = Double.valueOf(digits.format(principal * rate));
            }
            count++;
            years--;

        }
        if (years == 0 && a < b) {
            count = 0;
        }

        StringBuilder res = new StringBuilder();
        res.append(Integer.parseInt(tmp[0]) + " ");
        res.append(tmp[1] + " ");
        res.append(Double.parseDouble(tmp[2]) + " ");
        res.append(count);

        return res.toString();
    }
}
