import java.util.*;

/**
 * Created by Sunsea on 16/8/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] ss = new String[n];

            for (int i = 0; i < n; i++) {
                ss[i] = scanner.next();
            }
            System.out.println(trainOut(ss));
        }
        scanner.close();
    }

    private static String trainOut(String[] ss) {
        List<List<String>> result = new ArrayList<>();
        List<String> out = new ArrayList<>();
        List<String> unout = new ArrayList<>();

        trainOut(0, ss, out, unout, result);

        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                int min = a.size() < b.size() ? a.size() : b.size();

                for (int i = 0; i < min; i++) {
                    String as = a.get(i);
                    String bs = b.get(i);
                    if (as.compareTo(bs) != 0) {
                        return as.compareTo(bs);
                    }
                }
                return a.size() - b.size();
            }
        });

        StringBuilder builder = new StringBuilder();
        for (List<String> list : result) {
            StringBuilder b = new StringBuilder();
            for (String s: list) {
                b.append(s).append(' ');
            }
            b.setCharAt(b.length() - 1, '\n');

            builder.append(b);
        }
        return builder.toString();
    }

    /**
     * 火车进站
     * @param i 火车编号
     * @param ss 所有火车
     * @param out 火车已经出站的序列
     * @param unout 火车还未出站的序列
     * @param result 保存所有可能的结果
     */
    private static void trainOut(int i, String[] ss, List<String> out, List<String> unout, List<List<String>> result) {
        //所有火车已经进站
        if (i >= ss.length) {
            List<String> list = new ArrayList<>();
            for (String s: out) {
                list.add(s);
            }

            for (int j = unout.size() - 1; j >= 0; j--) {
                list.add(unout.get(j));
            }

            result.add(list);

            return;
        }

        //第i辆车进来就出去了
        out.add(ss[i]);
        trainOut(i + 1, ss, out, unout, result);
        //还原
        out.remove(out.size() - 1);

        //第i辆车进来没有出去
        unout.add(ss[i]);
        trainOut(i + 1, ss, out, unout, result);
        //还原
        unout.remove(unout.size() - 1);
    }
}
