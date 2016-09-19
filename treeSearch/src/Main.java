/**
 * Created by Sunsea on 16/8/27.
 */
public class Main {
    public static void main(String[] args) {
        Node root=Node.createTree();
        System.out.print("前序遍历： ");
        new Traverse().proOrder(root);
        System.out.println();
        System.out.print("前序递归遍历： ");
        new Traverse().recursiveProOrder(root);
        System.out.println();
        System.out.print("中序遍历： ");
        new Traverse().inOrder(root);
        System.out.println();
        System.out.print("中序递归遍历： ");
        new Traverse().recursiveInOrder(root);
        System.out.println();
        System.out.print("后序遍历： ");
        //new Traverse().postOrder(root);
        System.out.println();
        System.out.print("后序递归遍历： ");
        new Traverse().recursivePostOrder(root);
        System.out.println();
        System.out.print("层次遍历：");
        new Traverse().levelTraverse(root);
    }
}
