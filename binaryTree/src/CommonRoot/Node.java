package CommonRoot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunsea on 16/9/26.
 * 有一个普通二叉树，AB分别为两个子节点，求AB最近的公共父节点。
 */
public class Node {
    Node leftChild;
    Node rightChild;
    int data;

    public Node(Node leftChild, Node rightChild, int data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public boolean getPath(Node root, Node decNode, List<Node> array) {
        boolean findResult = false;
        if (root != null) {
            if (root == decNode) {
                array.add(root);
                findResult = true;
            }

            if (!findResult && root.leftChild != null) {
                findResult = this.getPath(root.leftChild, decNode, array);
                if (findResult) {
                    array.add(root);
                }
            }

            if (!findResult && root.rightChild != null) {
                findResult = this.getPath(root.rightChild, decNode, array);
                if (findResult) {
                    array.add(root);
                }
            }
        }
        return findResult;
    }

    static Node getCommonRoot(Node root, Node a, Node b) {
        Node common = null;
        List<Node> pathA = new ArrayList<>();
        List<Node> pathB = new ArrayList<>();
        a.getPath(root, a, pathA);
        b.getPath(root, b, pathB);

        for (Node NodeA: pathA) {
            for (Node NodeB: pathB) {
                if (NodeA == NodeB) {
                    common = NodeA;
                    break;
                }
            }
            if (common != null) {
                break;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        Node g = new Node(null,null,7);
        Node f = new Node(null,null,6);
        Node e = new Node(null,null,5);
        Node d = new Node(null,null,4);
        Node c = new Node(f,g,3);
        Node b = new Node(d,e,2);
        Node a = new Node(b,c,1);

        Node test = null;
        test = getCommonRoot(a,d,e);
        if (test != null) {
            System.out.println(test.data);
        }
    }
}
