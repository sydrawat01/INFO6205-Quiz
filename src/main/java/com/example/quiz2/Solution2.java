package com.example.quiz2;

import java.util.*;

public class Solution2 {
    // the root of current node
    private static int[] root;
    // the tree size of current node
    private int[] size;

    public Solution2 (int N) {
        root = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
            size[i] = 1;
        }
    }

    /* find the root of i */
    private int find(int i) {
        // TO DO
        while(i != root[i])
            i = root[i];
        return i;
    }

    /* union p and q */
    void union (int p, int q) {
        // TO DO
        int rootP = find(p);
        int rootQ = find(q);
        if(connected(rootP, rootQ))
            return;
        if(size[rootP] < size[rootQ]) {
            root[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            root[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    /* check if p and q are connected.*/
    boolean connected (int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        Solution2 uf = new Solution2(10);
        System.out.println("Union (2,9)");
        uf.union(2, 9);
        System.out.println("Union (3,4)");
        uf.union(3, 4);
        System.out.println("Union (4,9)");
        uf.union(4, 9);
        System.out.println("Union (5,6)");
        uf.union(5, 6);
        System.out.println("Union (3,5)");
        uf.union(3, 5);
        for( int i : root) {
            System.out.print(i + " ");
        }
    }
}
