package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bolitao
 */
public class Graph {
    /**
     * 权如果为这个值表示不连通
     */
    private static final int MAX_INTEGER = Integer.MAX_VALUE;
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
//    private boolean[] isVisited;
    public Graph(int vertexCount) {
        edges = new int[vertexCount][vertexCount];
        vertexList = new ArrayList<>(vertexCount);
        numOfEdges = 0;
//        isVisited = new boolean[vertexCount];
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

    public void createGraph(int vertexCount, String[] data, int[][] weight) {
        for (int i = 0; i < vertexCount; i++) {
            vertexList.add(data[i]);
            System.arraycopy(weight[i], 0, this.edges[i], 0, vertexCount);
//            for (int j = 0; j < vertexCount; j++) {
//                this.edges[i][j] = weight[i][j];
//            }
        }
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
     * 输出领接矩阵
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
        boolean[] isVisited = new boolean[this.getNumOfVertex()];
//        Arrays.fill(isVisited, false);
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
        boolean[] isVisited = new boolean[this.getNumOfVertex()];
//        Arrays.fill(isVisited, false);
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public int prim(int startIndex) {
        int sumWeight = 0;
        int[] isVisited = new int[this.getNumOfVertex()];
        isVisited[startIndex] = 1;
        // h1 与 h2 为两个顶点的下标
        int h1 = -1, h2 = -1;
        int minWeight = MAX_INTEGER; // 初始化为 MAX
        // 有 (getNumOfVertex() - 1) 条边
        for (int k = 1; k < getNumOfVertex(); k++) {
            for (int i = 0; i < getNumOfVertex(); i++) {
                for (int j = 0; j < getNumOfVertex(); j++) {
                    if (isVisited[i] == 1 && isVisited[j] == 0 && this.getWeight(i, j) < minWeight) {
                        minWeight = this.getWeight(i, j);
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.printf("Edge: (%d, %d), weight: %d.\n", h1, h2, minWeight);
            isVisited[h2] = 1;
            sumWeight += minWeight;
            minWeight = MAX_INTEGER;
        }
        return sumWeight;
    }

//    /**
//     * test of DFS and BFS
//     *
//     * @param args main method args
//     */
//    public static void main(String[] args) {
//        int vertexCount = 7;
//        String[] vertexValues = new String[]{"A", "B", "C", "D", "E", "F", "G"};
//        Graph graph = new Graph(vertexCount);
//        for (String vertexValue : vertexValues) {
//            graph.insertVertex(vertexValue);
//        }
//        graph.insertEdge(0, 1, 1);
//        graph.insertEdge(1, 3, 1);
//        graph.insertEdge(1, 4, 1);
//        graph.insertEdge(3, 4, 1);
//        graph.insertEdge(0, 2, 1);
//        graph.insertEdge(2, 5, 1);
//        graph.insertEdge(2, 6, 1);
//        graph.insertEdge(5, 6, 1);
//        System.out.println("Edges:");
//        graph.showGraph();
//        System.out.print("DFS: ");
//        graph.dfs();
//        System.out.print("\nBFS: ");
//        graph.bfs();
//    }

    /**
     * test of prim and kruskal
     *
     * @param args main method args
     */
    public static void main(String[] args) {
        String[] data = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        int vertexCount = data.length;
        int[][] weight = new int[][]{
                {MAX_INTEGER, 5, 7, MAX_INTEGER, MAX_INTEGER, MAX_INTEGER, 2},
                {5, MAX_INTEGER, MAX_INTEGER, 9, MAX_INTEGER, MAX_INTEGER, 3},
                {7, MAX_INTEGER, MAX_INTEGER, MAX_INTEGER, 8, MAX_INTEGER, MAX_INTEGER},
                {MAX_INTEGER, 9, MAX_INTEGER, MAX_INTEGER, MAX_INTEGER, 4, MAX_INTEGER},
                {MAX_INTEGER, MAX_INTEGER, 8, MAX_INTEGER, MAX_INTEGER, 5, 4},
                {MAX_INTEGER, MAX_INTEGER, MAX_INTEGER, 4, 5, MAX_INTEGER, 6},
                {2, 3, MAX_INTEGER, MAX_INTEGER, 4, 6, MAX_INTEGER}
        };
        Graph graph = new Graph(vertexCount);
        graph.createGraph(vertexCount, data, weight);
        graph.showGraph();
        System.out.print("\nDFS: ");
        graph.dfs();
        System.out.print("\n\nBFS: ");
        graph.bfs();
        System.out.println();
        System.out.println("\nPrim:");
        int primSumWeight = graph.prim(0);
        System.out.println("SumWeight: " + primSumWeight);
    }
}
