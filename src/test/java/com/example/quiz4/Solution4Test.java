package com.example.quiz4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Solution4Test {
    @Test
    public void testSort1() {
        final List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        Integer[] xs = list.toArray(new Integer[0]);
        Solution4<Integer> sorter = new Solution4<>();
        sorter.sort(xs);
        assertEquals(1, xs[0].intValue());
        assertEquals(2, xs[1].intValue());
        assertEquals(3, xs[2].intValue());
        assertEquals(4, xs[3].intValue());
    }

    @Test
    public void testSort2() {
        final List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(2);
        Integer[] xs = list.toArray(new Integer[0]);
        Solution4<Integer> sorter = new Solution4<>();
        sorter.sort(xs);
        assertEquals(1, xs[0].intValue());
        assertEquals(2, xs[1].intValue());
        assertEquals(3, xs[2].intValue());
        assertEquals(4, xs[3].intValue());
        assertEquals(5, xs[4].intValue());
        assertEquals(5, xs[5].intValue());
    }

    @Test
    public void testSwap() {
        final List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        Integer[] xs = list.toArray(new Integer[0]);
        Solution4<Integer> sorter = new Solution4<>();
        sorter.swap(xs, 0, 2);
        sorter.swap(xs, 1, 3);
        assertEquals(2, xs[0].intValue());
        assertEquals(1, xs[1].intValue());
        assertEquals(3, xs[2].intValue());
        assertEquals(4, xs[3].intValue());
    }

    @Test
    public void countSortingSwapCounts1() {
        final List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        Integer[] xs = list.toArray(new Integer[0]);
        Solution4<Integer> sorter = new Solution4<>();
        sorter.sort(xs);
        assertEquals(5, sorter.swaps);
    }

    @Test
    public void countSortingSwapCounts2() {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer[] xs = list.toArray(new Integer[0]);
        Solution4<Integer> sorter = new Solution4<>();
        sorter.sort(xs);
        assertEquals(0, sorter.swaps);
    }

}
