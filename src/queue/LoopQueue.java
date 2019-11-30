package queue;

/**
 * @author Boli Tao
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int tail, front, size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return this.data.length - 1;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    private void resize(int newCapacity) {
        E[] temp = (E[]) new Object[newCapacity];
        // 第一种遍历的方式
        for (int i = 0; i < size; i++) {
            temp[i] = data[(front + i) % data.length];
        }
        data = temp;
        front = 0;
        tail = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue: size = %d, capacity = %d.\n", size, getCapacity()));
        builder.append("front [");
        // 第二种遍历的方式
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            builder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(5);
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }
    }
}
