package queue;

/**
 * @author Boli Tao
 */
public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty, cannot dequeue.");
        }
        Node dequeueNode = head;
        E returnValue = dequeueNode.e;
        dequeueNode = null;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return returnValue;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: front ");
        Node current = head;
        while (current != null) {
            stringBuilder.append(current + "->");
            current = current.next;
        }
        stringBuilder.append("NULL tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }
        for (int i = 0; i < 10; i++) {
            linkedListQueue.dequeue();
            System.out.println(linkedListQueue);
        }
    }
}
