import org.example.DirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DirectedGraphTest {
    private DirectedGraph graph;

    @BeforeEach
    public void create(){
        graph = new DirectedGraph();
    }

    @Test
    void testAddVertex() {
        assertTrue(graph.addVertex(1));
        assertFalse(graph.addVertex(1));
    }

    @Test
    void testAddEdgeCreatesVertices() {
        graph.addEdge(1, 2);
        assertEquals(List.of(2), graph.getNeighbors(1));
    }

    @Test
    void testBfsSimpleGraph() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        List<Integer> result = graph.bfs(0);

        assertEquals(List.of(0, 1, 2, 3), result);
    }

    @Test
    void testBfsWithCycle() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        List<Integer> result = graph.bfs(0);

        assertEquals(List.of(0, 1, 2), result);
    }

    @Test
    void testBfsDisconnectedGraph() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.addEdge(10, 11);

        List<Integer> result = graph.bfs(0);

        assertEquals(List.of(0, 1, 2), result);
    }

    @Test
    void testBfsIsolatedVertex() {
        graph.addVertex(5);

        List<Integer> result = graph.bfs(5);

        assertEquals(List.of(5), result);
    }

    @Test
    void testBfsMissingStartVertex() {
        assertTrue(graph.bfs(999).isEmpty());
    }

    @Test
    void testLargeGraph() {
        int n = 100;

        for (int i = 0; i < n; i++) {
            graph.addVertex(i);
        }

        for (int i = 0; i < n - 1; i++) {
            graph.addEdge(i, i + 1);
        }

        List<Integer> result = graph.bfs(0);

        assertEquals(n, result.size());
        assertEquals(0, result.getFirst());
        assertEquals(n - 1, result.get(n - 1));
    }

    @Test
    void testRandomGraph() {
        Random random = new Random(42);

        int vertices = 50;
        int edges = 200;

        for (int i = 0; i < vertices; i++) {
            graph.addVertex(i);
        }

        for (int i = 0; i < edges; i++) {
            int from = random.nextInt(vertices);
            int to = random.nextInt(vertices);
            graph.addEdge(from, to);
        }

        List<Integer> result = graph.bfs(0);

        assertNotNull(result);
        assertTrue(result.contains(0));
    }
}
