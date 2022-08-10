package com.example.quiz10;

import org.junit.Assert;
import org.junit.Test;

public class Solution10Test {
    @Test
    public void test1(){
        int[][] edges = {{0,1},{1,2},{3,4}};
        Solution10 con = new Solution10();
        int res =  con.countComponents(5, edges);
        Assert.assertEquals(2,res);
    }

    @Test
    public void test2(){
        int[][] edges = {{0,1},{1,2},{3,4},{2,3}};
        Solution10 con = new Solution10();
        int res =  con.countComponents(5, edges);
        Assert.assertEquals(1,res);
    }

    @Test
    public void test3(){
        int[][] edges = {{0,0},{1,1},{2,2},{3,3}};
        Solution10 con = new Solution10();
        int res =  con.countComponents(4, edges);
        Assert.assertEquals(4,res);
    }

    @Test
    public void test4(){
        int[][] edges = {{0,1},{1,2},{2,3},{4,5},{5,6},{7,8}};
        Solution10 con = new Solution10();
        int res =  con.countComponents(9, edges);
        Assert.assertEquals(3,res);
    }

    @Test
    public void test5(){
        int[][] edges = {{0,1},{1,2},{3,4},{5,6},{6,1}};
        Solution10 con = new Solution10();
        int res =  con.countComponents(7, edges);
        Assert.assertEquals(2,res);
    }
}
