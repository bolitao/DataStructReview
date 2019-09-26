package array;

import java.util.WeakHashMap;

/**
 * 自定义的 Array 类
 *
 * @author 陶波利
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get() failed, index is illegal.");
        }
        return data[index];
    }

    public void set(int index, E value) {
        data[index] = value;
    }

    public boolean isContaianed(E value) {
        for (E m : data) {
            if (value.equals(m)) {
                return true;
            }
        }
        return false;
    }

    public int find(E value) {
        for (int i = 0; i < data.length; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, E value) {
//        if (size >= data.length) {
//            throw new IllegalArgumentException("add() method failed, array is full.");
//        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add() failed. Requirement: 0 <=index <= size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void addFirst(E value) {
        add(0, value);
    }

    public void addLast(E value) {
        add(size, value);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove() failed, index is illegal.");
        }
        E removedValue = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // loitering objects != memory leak
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            // TODO: / 4?
            resize(data.length / 2);
        }
        return removedValue;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E value) {
        int index = find(value);
        if (-1 != index) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * 交换索引为 i j 的元素
     *
     * @param i index i
     * @param j index j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
