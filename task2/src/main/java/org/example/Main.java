package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DirectedGraph graph = new DirectedGraph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        int startVertex = 2;
        List<Integer> bfsResult = graph.bfs(startVertex);

        System.out.println("BFS with start at "+ startVertex + ": " + bfsResult);

        System.out.println("Neighbours of vertex " + startVertex + ": " + graph.getNeighbors(2));
    }
}