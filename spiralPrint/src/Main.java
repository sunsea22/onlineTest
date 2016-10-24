/**
 * Created by Sunsea on 16/10/24.
 * 二维数组螺旋输出
 */
public class Main {
    public static Integer[][] doubleArray = new Integer[][]{{2, 3, 4},
                                                            {11, 12, 5},
                                                            {10, 13, 6},
                                                            {9, 8, 7}};
    public static void main(String[] args) {
        example();
    }

    public static void example() {
        char[] dire = {'E','S','W','N'};
        char p = dire[0];
        boolean loop = true;
        int h1 = 0, h2 = doubleArray[0].length - 1;
        int v1 = 0, v2 = doubleArray.length - 1;

        int i = 0;
        while (loop) {
            p = dire[i];
            if (v1 > v2 || h1 > h2) {
                loop = false;
            }
            switch (p) {
                case 'E':
                    forwardPrint(h1, h2, v1, v1, doubleArray);
                    ++v1;
                    break;
                case 'S':
                    forwardPrint(h2, h2, v1, v2, doubleArray);
                    --h2;
                    break;
                case 'W':
                    reversePrint(h1, h2, v2, v2, doubleArray);
                    --v2;
                    break;
                case 'N':
                    reversePrint(h1, h1, v1, v2, doubleArray);
                    ++h1;
                    break;
                default:
                    break;
            }
            ++i;
            if (4 == i) {
                i = 0;
            }
        }
    }

    public static void forwardPrint(int a1, int a2, int b1, int b2, Integer[][] c) {
        for (int i = b1; i <= b2; ++i) {
            for (int j = a1; j <= a2; ++j) {
                System.out.print(c[i][j] + ", ");
            }
        }
    }

    public static void reversePrint(int a1, int a2, int b1, int b2, Integer[][] c) {
        for (int i = b2; i >= b1; --i) {
            for (int j = a2; j >= a1; --j) {
                System.out.print(c[i][j] + ", ");
            }
        }
    }
}
