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

    public Graph(int vertexCount) {
        edges = new int[vertexCount][vertexCount];
        vertexList = new ArrayList<>(vertexCount);
        numOfEdges = 0;
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
    }
}
