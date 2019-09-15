package stack;

/**
 * @author Boli Tao
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
        System.out.println(arrayStack.peek());
    }
}
