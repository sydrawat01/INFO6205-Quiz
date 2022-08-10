package com.example.quiz11;

import java.util.Stack;

public class Topological {
    private Stack<Integer> topologicalOrder; // The first item should be in the top and the last one is in the bottom.

    private boolean[] marked;

    // Notice: you need to throw a RuntimeException when it has a cycle in the graph
    public Topological(Digraph G) throws RuntimeException {
        topologicalOrder = new Stack<>();

        marked = new boolean[G.V()];

        //TODO
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);

        for(boolean x : marked) {
            System.out.println(x);
            if(!x) throw new RuntimeException("Cycle found!");
        }
    }

    private void dfs(Digraph G, int v){
        //TODO
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
        topologicalOrder.push(v);
//        throw new RuntimeException("Cycle found!");
    }

    public Iterable<Integer> order(){
        return topologicalOrder;
    }

    /* Used for testing */
    public boolean[] getMarked(){
        return marked;
    }
}
