package array;

/**
 * @author Boli Tao
 */
public class Student {
    private String name;
    private int score;


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>(20);
        Student student1 = new Student("A", 20);
        Student student2 = new Student("B", 50);
        studentArray.addLast(student1);
        studentArray.addLast(student2);
        System.out.println(studentArray.toString());
    }
}
