import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     * 前序遍历 深度优先
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
                recursivePostOrder(root.left);
            }
            if (root.right != null) {
                recursivePostOrder(root.right);
            }
            System.out.print(root.value);
        }
    }

    /**
     * 后序遍历
     * 可以被遍历的节点都要进栈两次，所以添加第二个栈用来标示进栈次数
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
                //将所有左子节点进栈
                while (current != null) {
                    stack.add(current);
                    stack2.add(0);
                    top++;
                    current = current.left;
                }

                //取出栈顶节点，并判断其标志位
                current = stack.get(top);
                tag = stack2.get(top);
                if (tag == 0) {
                    //tag为0，表明该节点第一次进栈，还需要进栈一次，同时修改标志位
                    current = current.right;
                    stack2.add(1);
                }
                else {
                    //tag不为0，表明非首次进栈，可以遍历了
                    stack.remove(top);
                    top--;
                    System.out.print(current.value);
                    current = null;
                }
            } while (current != null || top != -1);
        }
    }

    /**
     * 层次遍历
     * 广度优先
     * @param root
     */
    public void levelTraverse(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value);
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
    }
}
