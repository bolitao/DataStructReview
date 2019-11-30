package graph;

/**
 * @author Boli
 */
public class Graph {
    private int num = 20; // capacity
    private Vertex[] vertices;
    int[][] adjMat;
    private int nVerts; // size
    private MyStack myStack; // 栈

    public Graph() {
        vertices = new Vertex[num];
        adjMat = new int[num][num];
        nVerts = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    // 添加节点
    public void addVertex(char lab) {
        vertices[nVerts++] = new Vertex(lab);
    }

    // 添加某两个节点之间的边
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    // 输出某个节点
    public void displayVertex(int v) {
        System.out.print(vertices[v].label);
    }

    // 获取未被访问的几点
    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertices[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }

    // 深度优先遍历
    public void dfs() {
        vertices[0].wasVisited = true;
        displayVertex(0);
        myStack = new MyStack();
        myStack.push(0);
        while (!myStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(myStack.peak());
            // 若不存在该节点
            if (v == -1) {
                myStack.pop();
            } else {
                vertices[v].wasVisited = true;
                displayVertex(v);
                myStack.push(v);
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertices[j].wasVisited = false;
        }
    }
}
