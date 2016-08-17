import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(count(input));
        }
        scanner.close();
    }

    public static String count(String input) {
        String str = input.toLowerCase();
        StringBuilder strRep = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            String tmp = "";
            while (i < str.length() &&str.charAt(i) != ' ' && str.charAt(i) != ',' && str.charAt(i) != '.') {
                tmp += str.charAt(i);
                i++;
            }
            if (tmp != "") {
                strRep.append(tmp + " ");
            }
        }
        String[] strTmp = strRep.toString().trim().split(" ");
        HashMap<String,Integer> maps = new HashMap<>();
        for (int i = 0; i < strTmp.length; i++) {
            if (maps.containsKey(strTmp[i])) {
                maps.put(strTmp[i],maps.get(strTmp[i]) + 1);
            }
            else {
                maps.put(strTmp[i],1);
            }
        }
        StringBuilder count = new StringBuilder();

        for (String key: maps.keySet()) {
            count.append(maps.get(key) + " ");
        }

        String[] countTmp = count.toString().trim().split(" ");
        String[] sortCount = maxValue(countTmp);
        int max = Integer.parseInt(sortCount[sortCount.length - 1]);
        int min = Integer.parseInt(sortCount[0]);

        StringBuilder maxKey = new StringBuilder();
        StringBuilder minKey = new StringBuilder();

        for (int i = 0; i < strTmp.length; i++) {
            if (maps.get(strTmp[i]) == max) {
                maxKey.append(strTmp[i] + " ");
            }
            else if (maps.get(strTmp[i]) == min) {
                minKey.append(strTmp[i] + " ");
            }
            else {

            }
        }

        String[] a = maxKey.toString().trim().split(" ");
        String[] b = minKey.toString().trim().split(" ");

//        String maxFin = maxKey.toString().trim().split(" ")[0];
//        String minFin = minKey.toString().trim().split(" ")[0];
        String maxFin = findFirst(strTmp,a);
        String minFin = findFirst(strTmp,b);

        return maxFin + "," + minFin;
    }

    public static String[] maxValue(String[] countValue) {
        for (int i = 0; i < countValue.length; i++) {
            for (int j = 0; j < countValue.length - i - 1; j++) {
                if (Integer.parseInt(countValue[j]) > Integer.parseInt(countValue[j+1])) {
                    String temp = countValue[j];
                    countValue[j] = countValue[j+1];
                    countValue[j+1] = temp;
                }
            }
        }
        return countValue;
    }

    public static String findFirst(String[] str, String[] target) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (str[i].equals(target[j])) {
                    res.append(i + " ");
                }
            }
        }
        String[] test = res.toString().trim().split(" ");
        int k = Integer.parseInt(res.toString().trim().split(" ")[0]);
        return str[k];
    }

}
