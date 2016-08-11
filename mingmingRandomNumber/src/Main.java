import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Sunsea on 16/8/11.
 * TreeSet为使用树来进行存储的Set接口提供了一个工具,对象按升序存储
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        TreeSet<Integer> tSet = new TreeSet<Integer>();
        while (num != 0) {
            tSet.add(scanner.nextInt());
            num--;
        }

        Iterator<Integer> it = tSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}
