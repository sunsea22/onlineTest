package printTree;

import java.util.*;

/**
 * Created by Sunsea on 16/8/17.
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 通过last记录上一层最后节点,nlast记录当前节点。
 * 弹出节点的值如果等于last记录的值就换行。
 * 关键就是明白在哪里换行。
 *
 */
public class PrintlnTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            TreeNode head = new PrintlnTree().buildTree(input);

            ArrayList<ArrayList<Integer>> res = new PrintlnTree().Print(head);

            for (int i = 0; i < res.size(); i++) {
                ArrayList<Integer> a = res.get(i);
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < a.size(); j++) {
                    tmp.append(a.get(j) + " ");
                }
                System.out.println(tmp.toString().trim());
            }
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(pRoot);
        TreeNode last,nlast;
        last = nlast = pRoot;
        ArrayList<Integer> a = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            a.add(t.val);
            if (t.left != null) {
                q.offer(t.left);
                nlast = t.left;
            }
            if (t.right != null) {
                q.offer(t.right);
                nlast = t.right;
            }
            if (t.val == last.val) {
                last = nlast;
                arr.add(a);
                a = new ArrayList<>();
            }
        }
        return arr;
    }

    public class TreeNode {
        int val = 0;

        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode buildTree(String input) {
        String[] str = input.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(str[0]));
        List<TreeNode> record = new ArrayList<>();
        record.add(new TreeNode(0));
        record.add(head);

        for (int i = 2; i < str.length + 1; i++) {
            TreeNode node = new TreeNode(Integer.parseInt(str[i-1]));

            if ((i/2 *2 == i)) {
                record.get(i/2).left = node;
            }
            else {
                record.get(i/2).right = node;
            }
            record.add(node);
        }
        return head;
    }
}
