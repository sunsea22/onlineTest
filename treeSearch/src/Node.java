/**
 * Created by Flyln on 16/8/27.
 */
public class Node {
    public int value;

    // 左子节点
    public Node left;

    // 右子节点
    public Node right;

    Node(int va) {
        value = va;
    }

    Node(int va, Node le, Node ri) {
        value = va;
        left = le;
        right = ri;
    }

    /**
     * 创建一颗二叉树
     *
     * @return 根节点
     */
    public static Node createTree() {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        return root;
    }
}
