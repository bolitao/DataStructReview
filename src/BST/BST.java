package BST;

import java.util.*;

/**
 * 二分搜索树，不包含重复元素
 *
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

    public E getMin() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E getMax() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E ret = getMin();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以 node 为根的最小节点
     *
     * @param node 根节点
     * @return 删除元素后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = getMax();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以 node 为根的值为 e 的节点
     *
     * @param node 根节点
     * @param e    待删除节点的值
     * @return 删除之后的根节点
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e equals node.e
            // 待删除结点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除结点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            /*
            待删除节点左右节点都不为空的情况：
            找到比待删除结点大的最小节点 a（即右子树的最小节点），用这个节点 a 顶替待删除结点
            注意 size 的变化情况
            另外：找待删除结点左子树的最大值作为顶替节点 a 也是可以的
            */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            size++;
            successor.left = node.left;
            node.left = node.right = null;
            size--;
            return successor;
        }
    }
}
