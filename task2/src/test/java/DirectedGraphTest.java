import org.example.DirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @Test
    void testBreadCrumbsSmall(){
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(3, 1);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(4, 2);
        graph.addEdge(5, 1);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Integer> result = graph.bfs(0);

        String exceptedOuput = "[0]\n" +
                "[0, 1]\n" +
                "[0, 1, 2]\n" +
                "[0, 1, 2, 5]\n" +
                "[0, 1, 2, 5, 6]\n" +
                "[0, 1, 2, 5, 6, 7]\n";

        assertEquals(exceptedOuput, outputStream.toString());
    }

    @Test
    void testBreadCrumbsLarge(){
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

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Integer> result = graph.bfs(10);

        String exceptedOuput = "[10]\n" +
                "[10, 6]\n" +
                "[10, 6, 13]\n" +
                "[10, 6, 13, 17]\n" +
                "[10, 6, 13, 17, 2]\n" +
                "[10, 6, 13, 17, 2, 3]\n" +
                "[10, 6, 13, 17, 2, 3, 9]\n" +
                "[10, 6, 13, 17, 2, 3, 9, 16]\n";

        assertEquals(exceptedOuput, outputStream.toString());
    }
}
