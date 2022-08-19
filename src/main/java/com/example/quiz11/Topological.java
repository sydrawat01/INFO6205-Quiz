package com.example.quiz11;

import java.util.Stack;

public class Topological {
    private Stack<Integer> topologicalOrder; // The first item should be in the top and the last one is in the bottom.
    Stack<Integer> cycle;
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;
    private boolean[] marked;

    // Notice: you need to throw a RuntimeException when it has a cycle in the graph
    public Topological(Digraph G) throws RuntimeException {
        topologicalOrder = new Stack<>();

        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        //TODO
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && cycle == null)
                dfs(G, v);
//        if (topologicalOrder.size() > G.V())
//            throw new RuntimeException("cycle found!");
    }

    private void dfs(Digraph G, int v){
        //TODO
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                if(check()) {
                    throw new RuntimeException();
                }
            }
        }
        onStack[v] = false;
        topologicalOrder.push(v);
    }

    /**
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph has a directed cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Returns a directed cycle if the digraph has a directed cycle, and {@code null} otherwise.
     * @return a directed cycle (as an iterable) if the digraph has a directed cycle,
     *    and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }

    private boolean check() {
        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }

    public Iterable<Integer> order(){
        return topologicalOrder;
    }

    /* Used for testing */
    public boolean[] getMarked(){
        return marked;
    }
}
