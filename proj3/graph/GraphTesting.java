package graph;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

/** Unit tests for the Graph class.
 *  @author Antonio Conteras
 */
public class GraphTesting {

    @Test
    public void emptyGraph() {
        DirectedGraph g = new DirectedGraph();
        assertEquals("Initial graph has vertices", 0, g.vertexSize());
        assertEquals("Initial graph has edges", 0, g.edgeSize());
    }

    @Test
    /** This is testing both add and both contains. */
    public void nonEmptyDirectedGraph() {
        DirectedGraph a = new DirectedGraph();
        a.add();
        a.add();
        a.add();
        a.add(1, 2);
        a.add(2, 3);
        a.add(1, 3);
        assertTrue(a.contains(1));
        assertTrue(a.contains(1, 3));
        assertFalse(a.contains(3, 1));
        assertEquals(a.maxVertex(), 3);
        assertEquals(a.edgeSize(), 3);
        assertEquals(a.outDegree(1), 2);
        assertEquals(2, a.successor(1, 0));
        assertEquals(a.successor(1, 1), 3);
        assertTrue(a.mine(3));
        assertFalse(a.mine(6));
    }

    @Test
    /** Will test the remove method. */
    public void nonEmptyDirectedGraphTwo() {
        DirectedGraph b = new DirectedGraph();
        b.add();
        b.add();
        b.add();
        b.add();
        b.add();
        assertEquals(b.maxVertex(), 5);
        b.remove(5);
        assertEquals(4, b.maxVertex());
        b.add(1, 2);
        assertEquals(b.edgeId(1, 2), 8);
        b.add(1, 3);
        b.add(4, 1);
        assertEquals(b.successor(1, 0), 2);
        assertEquals(b.successor(1, 1), 3);
        assertEquals(2, b.outDegree(1));
        assertEquals(1, b.inDegree(3));
        assertEquals(4, b.predecessor(1, 0));
        b.remove(4, 1);
        assertEquals(1, b.predecessor(2, 0));
    }

    @Test
    public void nonEmptyDirectdGraphThree() {
        DirectedGraph c = new DirectedGraph();
        c.add();
        c.add();
        c.add();
        c.add();
        c.add(2, 1);
        c.add(3, 1);
        c.add(4, 1);
        assertEquals(3, c.inDegree(1));
    }

    @Test
    public void nonEmptyDirectedGraphFour() {
        DirectedGraph d = new DirectedGraph();
        d.add();
        d.add();
        d.add();
        d.add();
        d.add(1, 3);
        d.add(2, 3);
        d.add(4, 3);
        assertEquals(3, d.inDegree(3));
        assertEquals(1, d.outDegree(4));
        assertEquals(4, d.maxVertex());
        assertEquals(1, d.predecessor(3, 0));
        assertEquals(2, d.predecessor(3, 1));
        assertEquals(4, d.predecessor(3, 2));
        d.remove(4);
        assertEquals(3, d.maxVertex());
        d.remove(3);
        assertEquals(2, d.maxVertex());
    }

    @Test
    public void nonEmptyDirectdGraphFive() {
        DirectedGraph f = new DirectedGraph();
        f.add();
        f.add();
        f.add();
        f.add();
        f.add(2, 1);
        f.add(3, 1);
        f.add(4, 1);
        assertEquals(2, f.predecessor(1, 0));
        assertEquals(3, f.predecessor(1, 1));
        assertEquals(4, f.predecessor(1, 2));
        f.remove(4);
        assertEquals(3, f.predecessor(1, 1));
    }

    @Test
    public void nonEmptyDirectedGraphSix() {
        DirectedGraph f = new DirectedGraph();
        f.add();
        f.add();
        f.add();
        f.add();
        f.add();
        f.add(2, 1);
        f.add(3, 1);
        f.add(4, 1);
        f.add(5, 1);
        assertEquals(2, f.predecessor(1, 0));
        assertEquals(3, f.predecessor(1, 1));
        assertEquals(4, f.predecessor(1, 2));
        assertEquals(5, f.predecessor(1, 3));
    }

    @Test
    public void emptyDirectedGraph() {
        DirectedGraph z = new DirectedGraph();
        assertEquals(0, z.successor(2, 0));
        assertEquals(0, z.predecessor(2, 0));
    }

    @Test
    public void nonEmptyDirectedThree() {
        DirectedGraph f = new DirectedGraph();
        f.add();
        f.add();
        f.add();
        f.add();
        f.add(1, 2);
        f.add(1, 3);
        f.add(1, 4);
        assertEquals(2, f.successor(1, 0));
        assertEquals(3, f.successor(1, 1));
        assertEquals(4, f.successor(1, 2));
        f.remove(4);
        assertEquals(2, f.successor(1, 0));
        assertEquals(3, f.successor(1, 1));
    }

    @Test
    public void nonEmptyDirectedFour() {
        DirectedGraph f = new DirectedGraph();
        f.add();
        f.add();
        f.add();
        f.add();
        f.add(2, 1);
        f.add(3, 1);
        f.add(4, 1);
        assertEquals(2, f.predecessor(1, 0));
        assertEquals(3, f.predecessor(1, 1));
        assertEquals(4, f.predecessor(1, 2));
        f.remove(4);
        assertEquals(2, f.predecessor(1, 0));
        assertEquals(3, f.predecessor(1, 1));
    }

    @Test
    public void nonEmptyUndirected() {
        UndirectedGraph a = new UndirectedGraph();
        a.add();
        a.add();
        a.add();
        assertEquals(3, a.maxVertex());
        a.add(1, 2);
        a.add(2, 3);
        a.add(3, 1);
        assertEquals(2, a.outDegree(1));
        assertEquals(2, a.inDegree(1));
        assertEquals(2, a.inDegree(3));
        a.remove(3);
        assertEquals(2, a.maxVertex());
        assertEquals(1, a.inDegree(1));
        assertEquals(1, a.inDegree(2));
        a.add();
        a.add(2, 3);
        a.add(3, 1);
        assertEquals(2, a.inDegree(1));
        assertEquals(2, a.inDegree(3));
    }

    @Test
    public void nonEmptyUndirectedTwo() {
        UndirectedGraph b = new UndirectedGraph();
        b.add();
        b.add();
        b.add();
        b.add();
        b.add();
        b.add(1, 3);
        b.add(3, 2);
        b.add(2, 4);
        b.add(4, 5);
        assertEquals(2, b.successor(3, 1));
        assertEquals(2, b.predecessor(3, 1));
        assertEquals(1, b.predecessor(3, 0));
        assertEquals(2, b.predecessor(4, 0));
    }

    @Test
    public void testingIteration() {
        DirectedGraph a = new DirectedGraph();
        a.add();
        a.add();
        a.add();
        a.add(3, 1);
        a.add(2, 1);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(3);
        expected.add(2);
        ArrayList<Integer> actual = new ArrayList<Integer>();
        for (int num : a.predecessors(1)) {
            actual.add(num);
        }
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testingIterationUnd() {
        UndirectedGraph a = new UndirectedGraph();
        a.add();
        a.add();
        a.add();
        a.add(3, 1);
        a.add(2, 1);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        ArrayList<Integer> actual = new ArrayList<Integer>();
        for (int num : a.predecessors(3)) {
            actual.add(num);
        }
        assertTrue(expected.equals(actual));
    }

    @Test
    public void nonEmptyDirectGraphThree() {
        DirectedGraph c = new DirectedGraph();
        c.add();
        c.add();
        c.add();
        assertEquals(0, c.successor(1, 0));
    }
}
