package com.example.quiz11;

import java.util.HashSet;
import java.util.Set;

public class Digraph {
    private final int V; // Vertex
    private int E; // Edge
    private Set<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = new HashSet[V];
        for(int v = 0; v < V; v++) adj[v] = new HashSet<>();
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
