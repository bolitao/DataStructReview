package stack;

import java.util.Random;

/**
 * @author Boli Tao
 */
public class SpeedTest {
    private static double testStack(Stack<Integer> stack, int operationCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operationCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int operationCount = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, operationCount);
        System.out.println("ArrayStack: " + time1 + " s.");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, operationCount);
        System.out.println("LinkedListStack: " + time2 + " s.");
        System.out.println(time1 / time2);
    }
}
