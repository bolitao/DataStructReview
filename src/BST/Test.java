package BST;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 陶波利
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer> integerBST = new BST<Integer>();
        int[] numbers = {11, 5, 3, 2, 6, 1, 3, 5, 6, 7, 22, 45};
        for (int i : numbers) {
            integerBST.add(i);
        }
        integerBST.preOrder();
        System.out.println("非递归前序遍历");
        integerBST.preOrderNR();
        System.out.println(integerBST);
        System.out.println("中序遍历: ");
        integerBST.inOrder();
        System.out.println("后序遍历: ");
        integerBST.postOrder();
        System.out.println("层序遍历: ");
        System.out.println(integerBST.levelOrder());
        BST<Integer> bst = new BST<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while (!bst.isEmpty()) {
            integers.add(bst.removeMin());
        }
        System.out.println("Size: " + integers.size());
        System.out.println(integers);
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i - 1) > integers.get(i)) {
                throw new IllegalArgumentException("Error.");
            }
        }
        System.out.println("Test completed.");
        BST<Integer> bst2 = new BST<Integer>();
        for (int i = 0; i < 20; i++) {
            bst2.add(random.nextInt(100));
        }
        System.out.println("递归层序遍历: ");
        System.out.println(bst2.levelOrder());
        System.out.println("非递归层序遍历: ");
        System.out.println(bst2.levelOrder2());
    }
}
