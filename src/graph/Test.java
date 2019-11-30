package graph;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6
        graph.addEdge(0, 1); // AB
        graph.addEdge(1, 3); // BD
        graph.addEdge(1, 4); // BE
        graph.addEdge(3, 4); // DE
        graph.addEdge(0, 2); // AC
        graph.addEdge(2, 5); // CF
        graph.addEdge(2, 6); // CG
        graph.addEdge(5, 6); // FG
//        System.out.println(Arrays.deepToString(graph.adjMat));
        System.out.print("深度优先: ");
        graph.dfs();
        System.out.println("\n陶波利 20161791");
    }
}
