import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/13.
 * 当Integer.valueOf(tmp)中tmp有非数字字符时会出现异常，这时就要用try catch
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(";");
            System.out.println(mobile(input));
        }

        scanner.close();
    }

    public static String mobile(String[] input) {
        int x = 0, y = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i].length() < 2 || input[i].length() > 3)
                continue;
            else {
                char cs = input[i].charAt(0);
                if (cs!='A'&&cs!='S'&&cs!='D'&&cs!='W')
                    continue;
                else {
                    String tmp = input[i].substring(1);
                    int res;
                    try {
                        res = Integer.valueOf(tmp);
                    } catch (Exception e) {
                        continue;
                    }
                    if (res >= 0 && res <= 99) {
                        switch (cs) {
                            case 'A':
                                x -= res;
                                break;
                            case  'D':
                                x += res;
                                break;
                            case  'S':
                                y -= res;
                                break;
                            case 'W' :
                                y += res;
                                break;
                        }
                    }
                    }
                }
            }
        return x + "," + y;
    }

}
