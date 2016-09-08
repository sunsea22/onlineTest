/**
 * Created by Sunsea on 16/9/5.
 * 这里的that.test(null)可以匹配上两个重载版本的test()方法，但是String版本比Object版本更具体，所以匹配上String版。
 */
public class Main {
    public void test(Object o) {
        System.out.println("Object");
    }

    public void test(String s) {
        System.out.println("String");
    }
    public static void main(String[] args) {
        Main test = new Main();
        test.test(null);

        /*这个考察的是Java的编译时常量、编译时常量折叠，以及String interning的知识
        * 当+运算符的左右两个操作数都是编译时常量时，这个+表达式也会被认为是编译时常量表达式。*/
        String a = "abc";
        String b = "ab" + "c";
        System.out.println(a == b);

        String ad = "-1";
        System.out.println(Integer.parseInt(ad));

        System.out.println(Math.pow(3,4));

        String str = "3";
        System.out.println(Double.parseDouble(str));

    }
}
