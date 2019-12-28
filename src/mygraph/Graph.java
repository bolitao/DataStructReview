package mygraph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;
    /**
     * 领接矩阵
     */
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public Graph(int vertexCount) {
        edges = new int[vertexCount][vertexCount];
        vertexList = new ArrayList<>(vertexCount);
        numOfEdges = 0;
        isVisited = new boolean[5]; // TODO
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
     * 打印图（其实就是输出领接矩阵
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
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1 v1
     * @param v2 v2
     * @return index
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
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    public static void main(String[] args) {
        int vertexCount = 5;
        String[] vertexValues = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(vertexCount);
        for (String vertexValue : vertexValues) {
            graph.insertVertex(vertexValue);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();
        System.out.println("\nDFS: ");
        graph.dfs();
    }
}
