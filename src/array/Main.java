package array;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(arr.toString());
        int[] scores = new int[]{99, 65, 88};
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
