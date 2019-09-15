package LinkedList.leetcode;

public class Sum {
    public static int sum(int[] array) {
        return sum(array, 0);
    }

    private static int sum(int[] array, int l) {
        if (l == array.length) {
            return 0;
        }
        return array[l] + sum(array, l + 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(array));
    }
}
