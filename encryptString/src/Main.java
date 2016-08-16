import java.util.*;

/**
 * Created by Sunsea on 16/8/16.
 * Set比较
 * HashSet：哈希表是通过使用称为散列法的机制来存储信息的，元素并没有以某种特定顺序来存放；
 * LinkedHashSet：以元素插入的顺序来维护集合的链接表，允许以插入的顺序在集合中迭代；
 * TreeSet：提供一个使用树结构存储Set接口的实现，对象以升序顺序存储，访问和遍历的时间很快。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(encrypt(str1, str2));
        }
        scanner.close();
    }

    public static String encrypt(String str1, String str2) {
       // char[] chArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] upperCase = new char[26];
        for (int i = 0; i < 26; i++) {
            upperCase[i] = (char)('A' + i);
        }
        String key = distinct(str1);
        Set<Character> tSet = new LinkedHashSet<>();

        for (int i = 0; i < key.length(); i++) {
            tSet.add(key.charAt(i));
        }

        for (int i = 0; i < 26; i++) {
            tSet.add(upperCase[i]);
        }

        StringBuilder tmp = new StringBuilder();

        Iterator<Character> it = tSet.iterator();
        while (it.hasNext()) {
            tmp.append(it.next());
        }

        char[] res = tmp.toString().toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') {
                int index = str2.charAt(i) - 'a';
                result.append((char)(res[index] + 32));
            }
            else if (str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z') {
                int index = str2.charAt(i) - 'A';
                result.append(res[index]);
            }
            else {
                result.append(str2.charAt(i));
            }
        }
        return result.toString();
    }

    public static String distinct(String str) {
        StringBuilder res = new StringBuilder();
        String tmp = str.toUpperCase();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < tmp.length(); i++) {
            set.add(tmp.charAt(i));
        }
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            res.append(it.next());
        }
        return res.toString();
    }
}
