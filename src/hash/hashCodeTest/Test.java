package hash.hashCodeTest;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 陶波利
 */
public class Test {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer) a).hashCode());
        int b = -42;
        System.out.println(((Integer) b).hashCode());
        double c = 3.41231234;
        System.out.println(((Double) c).hashCode());
        String d = "bolitao";
        System.out.println(d.hashCode());
        Student student = new Student(4, 2, "rua", "rue");
        System.out.println(student.hashCode());
        HashSet<Student> set = new HashSet<>();
        set.add(student);
        HashMap<Student, Integer> score = new HashMap<>();
        score.put(student, 100);
        Student student2 = new Student(4, 2, "Rua", "rue");
        System.out.println(student2.hashCode());
        System.out.println(student.equals(student2));
    }
}
