import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/8/16.
 */
public class Main {
    ArrayList<ArrayList<Integer>> resultsList = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int sum = scanner.nextInt();
            String path = scanner.next();
            TreeNode head = new Main().build(path);
            ArrayList<ArrayList<Integer>> res = new Main().FindPath(head, sum);

            if (res.size() == 0) {
                System.out.println("error");
            }

            else {
                for (int i = 0; i < res.size(); i++) {
                    ArrayList<Integer> tmp = res.get(i);
                    StringBuilder result = new StringBuilder();
                    for (int j = 0; j < tmp.size(); j++) {
                        result.append(tmp.get(j) + ",");
                    }
                    result.deleteCharAt(result.length() - 1);
                    System.out.println(result.toString());
                }
            }
        }
        scanner.close();
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //ArrayList<Integer> pathList = new ArrayList<Integer>();
        if (root == null) {
            return resultsList;
        }

        int curSum = 0;
        int index = 0;
        int []path = new int[1000];
        this.isTargetPath(root, target, curSum, path, index);

        return this.resultsList;
    }

    public void isTargetPath(TreeNode eleNode, int target, int curSum, int []path, int index) {
        if (eleNode == null) {
            return;
        }

        curSum += eleNode.val;
        // 把该节点包含进去
        path[index] = eleNode.val;
        index ++;

        // 当前已经是处于叶子节点，并且累计的和与target相等
        if (curSum == target && eleNode.left == null && eleNode.right == null) {
            // 将得到的结果放在外层结构中
            ArrayList<Integer> pathList = new ArrayList<Integer>();
            for (int i = 0; i < index; i++) {
                pathList.add(path[i]);
            }
            resultsList.add(pathList);
            return;
        }

        // 该节点有左子节点，前提还是要curSum 小于 target，否则递归就没有意义了
        if (curSum < target && eleNode.left != null) {
            this.isTargetPath(eleNode.left, target, curSum, path, index);
        }

        // 右子节点
        if (curSum < target && eleNode.right != null) {
            this.isTargetPath(eleNode.right, target, curSum, path, index);
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

    public TreeNode build(String input) {
        String[] tmp = input.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(tmp[0]));
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(0));
        list.add(head);
        for (int i = 2; i < tmp.length+1; i++) {
            TreeNode node = new TreeNode(Integer.parseInt(tmp[i-1]));
            if ((i/2)*2 == i) {
                list.get(i/2).left = node;
            }
            else {
                list.get(i/2).right = node;
            }
            list.add(node);
        }
        return head;
    }

}


