package graph;

import java.util.Arrays;

/**
 * @author bolitao
 */
public class KruskalCase {
    private int edgeNum;
    private char[] vertexes;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public KruskalCase(char[] vertexes, int[][] matrix) {
        int vertexNum = vertexes.length;
        this.vertexes = new char[vertexNum];
        System.arraycopy(vertexes, 0, this.vertexes, 0, vertexNum);
        this.matrix = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, vertexNum);
        }
        // 统计边数目
        for (int i = 0; i < vertexNum; i++) {
            for (int j = i + 1; j < vertexNum; j++) { // TODO: j = i + 1 而不是 j = 0
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    /**
     * print graph matrix
     * used in kruskal
     */
    public void print() {
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = 0; j < vertexes.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 对边进行排序
     * used in kruskal
     *
     * @param edges edges
     */
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 获得某个结点的索引
     * used in kruskal
     *
     * @param ch char
     * @return index of ch
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，放到 EData[] 数组
     * used in kruskal
     *
     * @return edges of the graph
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexes.length; i++) {
            for (int j = i + 1; j < vertexes.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexes[i], vertexes[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为 i 的顶点的终点（用于判断回路）
     * used in kruskal
     *
     * @param ends 各个顶点对应的终点
     * @param i    传入的顶点索引
     * @return 下标为 i 的顶点的终点索引
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        KruskalCase kruskalCase = new KruskalCase(vertexes, matrix);
        kruskalCase.print();
        EData[] edges = kruskalCase.getEdges();
        System.out.println("\n" + Arrays.toString(edges));
        kruskalCase.sortEdges(edges);
        System.out.println("\n" + Arrays.toString(edges));
    }
}
