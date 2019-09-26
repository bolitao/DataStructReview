package set;

import BST.BST;
import tool.FileOperation;

import java.io.File;
import java.util.ArrayList;

/**
 * 二分搜索树实现的集合
 *
 * @author 陶波利
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {
    private BST bst;

    public BinarySearchTreeSet() {
        bst = new BST();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        // 以《傲慢与偏见》英文 txt 做测试
        System.out.println("Pride and Prejudice: ");
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("共计单词数: " + words1.size());
            BinarySearchTreeSet<String> set1 = new BinarySearchTreeSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("忽略重复单词：" + set1.getSize());
        }
        System.out.println();
        // 以 A Tale of Two Cities txt 做测试
        System.out.println("A Tale of Two Cities: ");
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("共计单词数: " + words2.size());
            BinarySearchTreeSet<String> set2 = new BinarySearchTreeSet<>();
            for (String word : words2) {
                set2.add(word);
            }
            System.out.println("忽略重复单词：" + set2.getSize());
        }
    }
}
