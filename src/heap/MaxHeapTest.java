package heap;

import java.util.Random;

/**
 * MaxHeap 的测试类
 *
 * @author 陶波利
 */
public class MaxHeapTest {
    private static double testHeap(Integer[] integers, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> integerMaxHeap;
        if (isHeapify) {
            integerMaxHeap = new MaxHeap<>(integers);
        } else {
            integerMaxHeap = new MaxHeap<>();
            for (int number : integers) {
                integerMaxHeap.add(number);
            }
        }
        int[] arr = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            arr[i] = integerMaxHeap.extractMax();
        }
        // ↓验证最大堆
        for (int i = 1; i < integers.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error: 最大堆实现出现问题！");
            }
        }
        System.out.println("Completed!");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        double time2 = testHeap(testData, true);
        System.out.println("一个个添入堆中耗时：" + time1 + "\n使用 heapify() 添入堆中耗时：" + time2);
        /*
        JDK 11 (Windows 64) 运行结果：
        Completed!
        Completed!
        一个个添入堆中耗时：0.9817706
        使用 heapify() 添入堆中耗时：0.7843288
         */
    }
}
