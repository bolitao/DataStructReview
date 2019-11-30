package graph;

/**
 * 节点类
 */
public class Vertex {
    public char label;
    public Boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}
