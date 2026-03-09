package org.example;

import java.util.*;

public class DirectedGraph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public DirectedGraph(){
        adjacencyList = new HashMap<>();
    }

    public boolean addVertex(int v){
        if (!adjacencyList.containsKey(v)){
            adjacencyList.put(v, new ArrayList<>());
            return true;
        }
        return false;
    }

    public void addEdge(int from, int to){
        addVertex(from);
        addVertex(to);
        if (!adjacencyList.get(from).contains(to)){
            adjacencyList.get(from).add(to);
        }
    }

    public List<Integer> bfs(int start){
        if (!adjacencyList.containsKey(start)){
            return new ArrayList<>();
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        visited.add(start);
        queue.add(start);

        int vertex;

        while (!queue.isEmpty()){
            vertex = queue.poll();
            result.add(vertex);

            for (int neighbour : adjacencyList.get(vertex)){
                if (!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }

    public List<Integer> getNeighbors(int v){
        if (adjacencyList.containsKey(v)) {
            return adjacencyList.get(v);
        }
        return null;
    }
}
