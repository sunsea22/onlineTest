import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/13.
 * 私有IP地址和A,B,C,D,E类地址是不冲突的，什么意思呢？
 * 就是 A,B,C,D,E类地址也可以是私有地址，只要他们符合私有地址的规则。
 * 所以不能用if...，else if...，而应该用if... if...。
 * ip就是要保证：每一段都是在【0,255】之间，注意0.x.x.x零开头的是正确的ip，但是它不属于任何统计的类型
 * mark同样保证：每一段都在【0,255】之间，并且是1111...000...这种形式，即前边全是1，后边全是0
 *
 */
public class Main {
    private static int countA = 0;
    private static int countB = 0;
    private static int countC = 0;
    private static int countD = 0;
    private static int countE = 0;
    private static int countError = 0;
    private static int countPrivate = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.next();
            identify(input);
        }
        System.out.println(countA + " " + countB + " " + countC + " " + countD + " " + countE + " " + countError + " " + countPrivate);
        scanner.close();
    }

    public static void identify(String input) {
        String[] ipAndMask = input.split("~");
        String ip = ipAndMask[0];
        String mask = ipAndMask[1];
        String[] ips = ip.split("\\.");
        int ipInts = Integer.parseInt(ips[0]);
        int ipInts1 = Integer.parseInt(ips[1]);
        if (checkIp(ip) && checkMask(mask)) {
            if (ipInts >= 1 && ipInts <= 126) {
                countA++;
            }

            if (ipInts >= 128 && ipInts <= 191) {
                countB++;
            }

            if (ipInts >= 192 && ipInts <= 223) {
                countC++;
            }

            if (ipInts >= 224 && ipInts <= 239) {
                countD++;
            }
            if (ipInts >= 240 && ipInts <= 255) {
                countE++;
            }

            if (ipInts == 10) {
                countPrivate++;
            }

            if (ipInts == 172) {
                if (ipInts1 >= 16 && ipInts1 <= 31) {
                    countPrivate++;
                }
            }

            if (ipInts == 192) {
                if (ipInts1 == 168) {
                    countPrivate++;
                }
            }
        }
        else {
            countError++;
        }

    }

    public static boolean checkIp(String ip) {
        String[] ips = ip.split("\\.");
        for (String str: ips) {
            if (str.length() == 0) return false;
            if (Integer.parseInt(str) > 255 || Integer.parseInt(str) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkMask(String mask) {
        String[] masks = mask.split("\\.");

        for (String str: masks) {
            if (Integer.parseInt(str) > 255 || Integer.parseInt(str) < 0) {
                return false;
            }
        }

        int temp = Integer.parseInt(masks[0]);
        for (int i = 1; i < 4; i++) {
            temp = temp << 8;
            temp += Integer.parseInt(masks[i]);
        }
        if ((temp | (temp - 1)) != 0xffffffff || temp == 0xffffffff) {
            return false;
        }
        return true;
    }

}
