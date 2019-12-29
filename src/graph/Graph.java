package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    /**
     * 结点
     */
    private ArrayList<String> vertexList;
    /**
     * 领接矩阵 -边 - 适合用于表示稠密图
     */
    private int[][] edges;
    /**
     * 边数
     */
    private int numOfEdges;
    /**
     * 存储所有节点是否被访问的信息
     */
    private boolean[] isVisited;

    public Graph(int vertexCount) {
        edges = new int[vertexCount][vertexCount];
        vertexList = new ArrayList<>(vertexCount);
        numOfEdges = 0;
        isVisited = new boolean[vertexCount];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * insert edge
     *
     * @param vertex1 vertex 1
     * @param vertex2 vertex 2
     * @param weight  weight of edge
     */
    public void insertEdge(int vertex1, int vertex2, int weight) {
        edges[vertex1][vertex2] = weight;
        edges[vertex2][vertex1] = weight;
        numOfEdges++;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 打印图（输出领接矩阵）
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 返回一个邻结点的下标
     *
     * @param index index
     * @return index of the neighbor vertex, return -1 if not exists
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * v1 的下下个结点
     *
     * @param v1 v1
     * @param v2 v2
     * @return 返回 edges[v1] 中 edges[v1][v2] 的后一个结点索引
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + " ");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        Arrays.fill(isVisited, false);
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    private void bfs(boolean[] isVisited, int i) { // 广度优先搜索，使用队列作为辅助
        int u; // 队列头节点的下标
        int w;
        Queue<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i) + " ");
        isVisited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            u = queue.poll();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + " ");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs() {
        Arrays.fill(isVisited, false);
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public static void main(String[] args) {
        int vertexCount = 7;
        String[] vertexValues = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        Graph graph = new Graph(vertexCount);
        for (String vertexValue : vertexValues) {
            graph.insertVertex(vertexValue);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 4, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        System.out.println("Edges:");
        graph.showGraph();
        System.out.print("DFS: ");
        graph.dfs();
        System.out.print("\nBFS: ");
        graph.bfs();
    }
}
