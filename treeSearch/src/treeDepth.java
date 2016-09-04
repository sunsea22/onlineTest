import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by sunsea on 16/9/4.
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class treeDepth {
    /**
     * 递归求解
     * @param root
     * @return
     */
    public int TreeDepth(Node root) {
        if (root == null) return 0;
        else return Math.max(1+TreeDepth(root.left), 1+TreeDepth(root.right));
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public int TreeDepth1(Node root) {
        Deque<Node> q = new LinkedList<>();

        if (root == null) return 0;
        q.push(root);
        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            level++;

            while (len > 0) {
                Node tmp = q.getFirst();
                q.pop();
                if (tmp.left != null) q.push(tmp.left);
                if (tmp.right != null) q.push(tmp.right);
                len--;
            }
        }
        return level;
    }
}
