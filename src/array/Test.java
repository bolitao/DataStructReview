package array;

public class Test {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.addLast(5);
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
        array.removeElement(3);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
//        array.add(1, 200);
//        System.out.println(array);
//        array.addFirst(-1);
//        System.out.println(array);
//        array.remove(11);
//        System.out.println(array);
//        array.removeElement(200);
//        System.out.println(array);
//        array.removeElement(4);
//        System.out.println(array);
//        array.removeFirst();
//        System.out.println(array);
//        array.removeLast();
//        System.out.println(array);
    }
}
