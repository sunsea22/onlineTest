import java.util.ArrayList;

/**
 * Created by Sunsea on 16/8/27.
 */
public class Traverse {
    /**
     * 递归前序遍历
     * @param root
     */
    public void recursiveProOrder(Node root) {
        if (root != null) {
            System.out.print(root.value);
        }

        if (root.left != null) {
            recursiveProOrder(root.left);
        }

        if (root.right != null) {
            recursiveProOrder(root.right);
        }
    }

    /**
     * 前序遍历
     * @param root
     */
    public void proOrder(Node root) {
        ArrayList<Node> stack = new ArrayList<>();
        int top = -1;
        Node current = root;

        while (true) {
            if (current != null) {
                System.out.print(current.value);
            }

            if (current.right != null) {
                stack.add(current.right);
                top++;
            }

            if (current.left != null) {
                stack.add(current.left);
                top++;
            }

            if (top > -1) {
                current = stack.get(top);
                stack.remove(top--);
            }
            else {
                break;
            }
        }
    }

    /**
     * 递归中序遍历
     * @param root
     */
    public void recursiveInOrder(Node root) {
        if (root != null) {
            if (root.left != null) {
                recursiveInOrder(root.left);
            }
            System.out.print(root.value);
            if (root.right != null) {
                recursiveInOrder(root.right);
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(Node root) {
        if (root != null) {
            ArrayList<Node> stack = new ArrayList<>();
            int top = -1;
            Node current = root;

            while (current != null || top > -1) {
                if (current != null) {
                    stack.add(current);
                    top++;
                    current = current.left;
                }
                else {
                    current = stack.get(top);
                    stack.remove(top--);
                    System.out.print(current.value);
                    current = current.right;
                }
            }
        }
    }

    /**
     * 递归后序遍历
     * @param root
     */
    public void recursivePostOrder(Node root) {
        if (root != null) {
            if (root.left != null) {
                recursiveInOrder(root.left);
            }
            if (root.right != null) {
                recursiveInOrder(root.right);
            }
            System.out.print(root.value);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(Node root) {
        if (root != null) {
            ArrayList<Node> stack = new ArrayList<>();
            ArrayList<Integer> stack2 = new ArrayList<>();
            int top = -1;
            int tag;
            Node current = root;

            do {
                while (current != null) {
                    stack.add(current);
                    stack2.add(0);
                    top++;
                    current = current.left;
                }

                current = stack.get(top);
                tag = stack2.get(top);
                if (tag == 0) {
                    current = current.right;
                    stack2.add(1);
                }
                else {
                    stack.remove(top);
                    top--;
                    System.out.print(current.value);
                    current = null;
                }
            } while (current != null || top != -1);
        }
    }
}
