package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DirectedGraph graph = new DirectedGraph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 7);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(3, 6);
        graph.addEdge(4, 0);
        graph.addEdge(4, 7);
        graph.addEdge(5, 8);
        graph.addEdge(5, 9);
        graph.addEdge(6, 2);
        graph.addEdge(6, 3);
        graph.addEdge(8, 7);
        graph.addEdge(8, 11);
        graph.addEdge(8, 12);
        graph.addEdge(9, 13);
        graph.addEdge(10, 6);
        graph.addEdge(10, 13);
        graph.addEdge(10, 17);
        graph.addEdge(11, 14);
        graph.addEdge(12, 9);
        graph.addEdge(12, 13);
        graph.addEdge(13, 9);
        graph.addEdge(0, 1);
        graph.addEdge(15, 16);
        graph.addEdge(16, 13);
        graph.addEdge(17, 16);



        int startVertex = 10;
        List<Integer> bfsResult = graph.bfs(startVertex);

        System.out.println("BFS with start at "+ startVertex + ": " + bfsResult);

        System.out.println("Neighbours of vertex " + startVertex + ": " + graph.getNeighbors(startVertex));
    }
}