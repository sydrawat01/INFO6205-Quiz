package com.example.quiz2;

import org.junit.Test;
import org.junit.Assert;

public class Solution2Test {
    @Test
    public void test1(){
        Solution2 uf = new Solution2(10);

        uf.union(2, 2);
        uf.union(4, 5);

        Assert.assertTrue(uf.connected(2, 2));
        Assert.assertFalse(uf.connected(4, 7));
    }

    @Test
    public void test2(){
        Solution2 uf = new Solution2(100);

        uf.union(1, 99);

        Assert.assertTrue(uf.connected(1, 99));
    }

    @Test
    public void test3(){
        Solution2 uf = new Solution2(1000);

        uf.union(1, 990);
        uf.union(1, 501);

        Assert.assertTrue(uf.connected(501, 990));
    }

    @Test
    public void test4(){
        Solution2 uf = new Solution2(100);

        uf.union(2, 83);
        uf.union(7, 2);

        Assert.assertTrue(uf.connected(7, 83));
        Assert.assertTrue(uf.connected(2, 7));
        Assert.assertFalse(uf.connected(2, 82));
    }

    @Test
    public void test5(){
        int n = 100;
        Solution2 uf = new Solution2(n);
        uf.union(2, 83);
        uf.union(99, 27);
        uf.union(8, 2);
        uf.union(99, 8);

        Assert.assertTrue(uf.connected(99, 83));
        Assert.assertTrue(uf.connected(2, 27));

        uf.union(81, 23);
        uf.union(21,9);
        uf.union(11,7);
        uf.union(23, 9);
        uf.union(11, 81);

        Assert.assertTrue(uf.connected(81, 7));
        Assert.assertTrue(uf.connected(11, 21));

        Assert.assertFalse(uf.connected(81, 99));
        Assert.assertFalse(uf.connected(7, 8));

        Assert.assertFalse(uf.connected(11, 1));

        uf.union(11, 8);

        Assert.assertTrue(uf.connected(81, 99));
        Assert.assertTrue(uf.connected(7, 8));
    }
}
