package com.example.quiz5;

import java.util.*;

/**
 * Implement QuickSort with T which is a generic type. You have to implement the sort and partition logic.
 * You will need to add your code in the TODO section.
 * There are 2 TODOs. they're in the sort and partition functions.
 * You must not make any changes apart from the code.
 * @param <T> Generic Type to run the QuickSort algorithm with generic data that is of type Comparable<T>.
 */
public class Solution5<T extends Comparable<T>> {
    /*
     * This method accepts a list of elements of generic type T which are comparable
     * */
    public void sort(List<T> a) {
        sort(a, 0, a.size() - 1);
    }

    private  void sort(List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        int pivot = partition(list, lo, hi);
        //TODO
        sort(list, lo, pivot-1);
        sort(list, pivot+1, hi);
    }

    /*
     *
     * Implement the partition method that determines the pivot element.
     * For T a and T b,
     * a.compareTo(b) == 0 -> a == b;
     * a.compareTo(b) < 0 -> a < b;
     * a.compareTo(b) > 0 -> a > b
     * */
    public int partition(List<T> list, int lo, int hi) {
        //TODO
        T pivot = list.get(lo);

        while (lo < hi) {
            while (lo < hi && !less(list.get(hi), pivot))
                hi--;
            list.set(lo, list.get(hi));
            while (lo < hi && less(list.get(lo), pivot))
                lo++;
            list.set(hi, list.get(lo));
        }
        list.set(lo, pivot);
        return lo;
    }

    private void swap(List<T> list, int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
