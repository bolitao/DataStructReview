package heap;

import array.Array;

import java.util.Random;

/**
 * @author 陶波利
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 构造函数：将传入数组组成为最大堆
     *
     * @param arr 待化为最大堆的数组
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * @param index index
     * @return index 的父节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e 待添加的元素值
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 为满足最大堆性质而设计的元素上浮方法
     *
     * @param k 需要被上浮的元素索引
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = getMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    public E getMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Size is 0, no element in heap.");
        }
        return data.get(0);
    }

    /**
     * 为满足最大堆性质而设计的元素下沉方法
     * TODO: 需要进一步理解
     *
     * @param k 需要被下沉的元素索引
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            // ↑此时 j 表示孩子节点中更大元素的索引
            if (data.get(k).compareTo(data.get(j)) > 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    public E replace(E e) {
        E ret = getMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    /**
     * 测试类
     *
     * @param args args
     */
    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error: 最大堆实现出现问题！");
            }
        }
        System.out.println("Completed!");
    }
}
