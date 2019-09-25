package BST;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
//        int[] numbers = {11, 5, 3, 2, 6, 1, 3, 5, 6, 7, 22, 45};
//        for (int i : numbers) {
//            bst.add(i);
//        }
//        bst.preOrder();
//        System.out.println("非递归前序遍历");
//        bst.preOrderNR();
//        System.out.println(bst);
//        System.out.println("中序遍历: ");
//        bst.inOrder();
//        System.out.println("后序遍历: ");
//        bst.postOrder();
//        System.out.println("层序遍历: ");
//        bst.levelOrder();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while (!bst.isEmpty()) {
            integers.add(bst.removeMin());
        }
        System.out.println(integers);
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i - 1) > integers.get(i)) {
                throw new IllegalArgumentException("Error.");
            }
        }
        System.out.println("Test completed.");
    }
}
