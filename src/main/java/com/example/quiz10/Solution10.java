package com.example.quiz10;

/* LeetCode: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 323. Number of Connected Components in an Undirected Graph
 * You have a graph of n nodes. You are given an integer n and an array edges where
 * edges[i] = [ai, bi] indicates that there is an edge between `ai` and `bi` in the graph.
 * Return the number of connected components in the graph.
 */

import java.util.*;

public class Solution10 {
    private void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] = 1;
        for (int i = 0; i < adjList[startNode].size(); i++)
        {
            if (visited[adjList[startNode].get(i)] == 0)
            {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        int components = 0; //total number of connected components
        int[] visited = new int[n]; //array to mark the visited nodes in the graph

        //TODO:
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }
}
