package queue;

import java.util.Random;

/**
 * @author Boli Tao
 */
public class Test {
    private static double testQueue(Queue<Integer> queue, int operationCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operationCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int operationCount = 10;
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> integerLoopQueue = new LoopQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double arrayTime = testQueue(integerArrayQueue, operationCount);
        double loopTime = testQueue(integerLoopQueue, operationCount);
        double listTime = testQueue(linkedListQueue, operationCount);
        System.out.println("ArrayQueue: " + arrayTime + " s.\nLoopQueue: " + loopTime + " s.\nLinkedListQueue: " + listTime + " s.");
        System.out.println("arrayTime / loopTime: " + arrayTime / loopTime);
        System.out.println("loopTime / listTime: " + loopTime / listTime);
    }
}
