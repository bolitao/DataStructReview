package graph;

public class MyStack {
    private final int size = 20;
    private int[] st;
    private int top;

    // 初始化
    public MyStack() {
        st = new int[size];
        top = -1;
    }

    // 进栈
    public void push(int j) {
        st[++top] = j;
    }

    // 出栈
    public int pop() {
        return st[top--];
    }

    // 返回栈顶元素
    public int peak() {
        return st[top];
    }

    // 判断栈是否为空
    public Boolean isEmpty() {
        return (top == -1);
    }
}
