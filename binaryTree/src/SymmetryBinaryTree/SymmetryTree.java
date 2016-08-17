package SymmetryBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/17.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            TreeNode head = new SymmetryTree().buildTree(input);
            System.out.println(new SymmetryTree().isSymmetrical(head));
        }

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        TreeNode node = getMirror(pRoot);
        return isSymmetrical(pRoot,node);

//        if (pRoot == null) {
//            return true;
//        }
//        return comRoot(pRoot.left,pRoot.right);
    }

    public boolean isSymmetrical(TreeNode pRoot, TreeNode node) {
        if (pRoot == null && node == null) {
            return true;
        }

        else if (pRoot == null || node == null) {
            return false;
        }
        if (pRoot.val == node.val) {
            return isSymmetrical(pRoot.left,node.left)&&isSymmetrical(pRoot.right, node.right);
        }
        return false;
    }

    public TreeNode getMirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        TreeNode root = new TreeNode(pRoot.val);
        root.right = getMirror(pRoot.left);
        root.left = getMirror(pRoot.right);
        return root;
    }

//    private boolean comRoot(TreeNode left, TreeNode right) {
//        if (left == null) return right == null;
//        if (right == null) return false;
//        if (left.val != right.val) return false;
//        return comRoot(left.right,right.left) && comRoot(left.left,right.right);
//    }

    public TreeNode buildTree(String input) {
        String[] str = input.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(str[0]));
        List<TreeNode> record = new ArrayList<>();
        record.add(new TreeNode(0));
        record.add(head);

        for (int i = 2; i < str.length + 1; i++) {
            TreeNode node = new TreeNode(Integer.parseInt(str[i-1]));

            if ((i/2 *2) == i) {
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
