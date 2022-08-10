package com.example.quiz11;

import org.junit.Assert;
import org.junit.Test;

public class Solution11Test {
    @Test
    public void testChecked(){
        Digraph digraph = new Digraph(100);

        Topological topological = new Topological(digraph);

        boolean allChecked = true;

        for(boolean b : topological.getMarked()){
            if(!b) {
                allChecked = false;
                break;
            }
        }

        Assert.assertTrue(allChecked);
    }

    @Test
    public void testOrder1() {
        int V = 2;

        Digraph digraph = new Digraph(V);
        digraph.addEdge(0, 1);

        Topological topological = new Topological(digraph);

        int[] expected = new int[]{0, 1};

        Assert.assertEquals(arrayToString(expected), topologicalToString(topological));
    }

    @Test
    public void testOrder2() {
        int V = 5;

        Digraph digraph = new Digraph(V);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 4);
        digraph.addEdge(1, 2);
        digraph.addEdge(3, 0);

        Topological topological = new Topological(digraph);

        int[] expected = new int[]{3, 0, 1, 2, 4};

        Assert.assertEquals(arrayToString(expected), topologicalToString(topological));
    }


    @Test
    public void testOrder3() {
        int V = 10;

        Digraph digraph = new Digraph(V);
        digraph.addEdge(8, 6);
        digraph.addEdge(0, 1);
        digraph.addEdge(7, 9);
        digraph.addEdge(2, 5);
        digraph.addEdge(1, 7);
        digraph.addEdge(3, 4);
        digraph.addEdge(9, 2);
        digraph.addEdge(4, 8);
        digraph.addEdge(1, 3);
        digraph.addEdge(6, 7);

        Topological topological = new Topological(digraph);

        int[] expected = new int[]{0, 1, 3, 4, 8, 6, 7, 9, 2, 5};

        Assert.assertEquals(arrayToString(expected), topologicalToString(topological));
    }

    @Test(expected = RuntimeException.class)
    public void testCycle() {
        int V = 5;

        Digraph digraph = new Digraph(V);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 1);

        Topological topological = new Topological(digraph);

    }


    private String topologicalToString(Topological topological){
        StringBuilder sb = new StringBuilder();
        for(int v : topological.order()) {
            sb.insert(0, v + " -> ");
        }

        sb.delete(sb.length() - 4, sb.length());

        return sb.toString();
    }

    private String arrayToString(int[] expected){
        StringBuilder sb = new StringBuilder();
        for(int v : expected) {
            sb.append( v + " -> ");
        }

        sb.delete(sb.length() - 4, sb.length());

        return sb.toString();
    }
}
