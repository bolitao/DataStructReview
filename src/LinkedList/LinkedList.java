package LinkedList;

/**
 * @author Boli Tao
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyNode;
    private int size;

    public LinkedList() {
        dummyNode = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add() filed, illegal index.");
        }
        Node prev = dummyNode;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal argument");
        }
        Node current = dummyNode.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void update(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal argument");
        }
        Node node = dummyNode.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.e = e;
    }

    public boolean contains(E e) {
        Node current = dummyNode.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal argument");
        }
        Node prev = dummyNode;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node deletedNode = prev.next;
        E deletedData = deletedNode.e;
        prev.next = deletedNode.next;
        size--;
        // deletedNode = null;
        deletedNode.next = null;
        return deletedData;
    }

    public E removeFirst() {
        return delete(0);
    }

    public E removeLast() {
        return delete(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // current != null 而不是 current.next != null
        for (Node current = dummyNode.next; current != null; current = current.next) {
            stringBuilder.append(current + "->");
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.add(0, 0);
        System.out.println(linkedList);
        linkedList.addFirst(0);
        System.out.println(linkedList);
        linkedList.addLast(0);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.delete(3);
        System.out.println(linkedList);
    }
}
