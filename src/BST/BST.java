package BST;

import java.util.*;

/**
 * @author Boli Tao
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left, right;

        public E getE() {
            return e;
        }

        Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }


        public void setE(E e) {
            this.e = e;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向二叉树中插入节点，忽略重复元素
     *
     * @param root 根节点
     * @param e    需要插入的元素
     * @return 插入新节点后二叉树的根
     */
    private Node add(Node root, E e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(root.e) < 0) {
            root.left = add(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        }
        return root;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 判断以 root 为根的树是否含有值 e
     *
     * @param root 树的根
     * @param e    需要查询的值
     * @return 是否找到
     */
    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    /**
     * 非递归的前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.e);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以 root 为根的二分搜索树
     *
     * @param root 树根
     */
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以 root 为根的二叉搜索树
     * 重要特性：二分搜索树的中序遍历输出是按大小顺序排列的
     *
     * @param root 根节点
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBSTString(root, 0, result);
        return result.toString();
    }

    private void generateBSTString(Node root, int depth, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append(generateDepthString(depth)).append("null\n");
            return;
        }
        stringBuilder.append(generateDepthString(depth)).append(root.e).append("\n");
        generateBSTString(root.left, depth + 1, stringBuilder);
        generateBSTString(root.right, depth + 1, stringBuilder);
    }

    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < depth; i++) {
//            builder.append("Depth: ").append(depth).append(", ");
//        }
        builder.append("Depth: ").append(depth).append(", ");
        return builder.toString();
    }

    /**
     * 层序遍历/深度优先遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.e);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] numbers = {11, 5, 3, 2, 6, 1, 3, 5, 6, 7, 22, 45};
        for (int i : numbers) {
            bst.add(i);
        }
        bst.preOrder();
        System.out.println("非递归前序遍历");
        bst.preOrderNR();
        System.out.println(bst);
        System.out.println("中序遍历: ");
        bst.inOrder();
        System.out.println("后序遍历: ");
        bst.postOrder();
        System.out.println("层序遍历: ");
        bst.levelOrder();
    }
}
