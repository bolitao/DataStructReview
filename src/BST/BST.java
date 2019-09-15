package BST;

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

        public Node(E e) {
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
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node root, E e) {
        // 终止条件
        if (e.equals(root.e)) {
            return;
        } else if (e.compareTo(root.e) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(root.e) > 0 && root.left == null) {
            root.right = new Node(e);
            size++;
            return;
        }

        // 递归
        if (e.compareTo(root.e) < 0) {
            add(root.left, e);
        } else {
            add(root.right, e);
        }
    }
}
