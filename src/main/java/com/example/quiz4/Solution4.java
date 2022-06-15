package com.example.quiz4;

public class Solution4<T extends Comparable<T>> {
    public int swaps = 0;
    /**
     *
     * @param arr   sort the array arr
     */
    public void sort(T[] arr) {
        // TO DO
        for(int i=1; i< arr.length; i++) {
            for(int min=i; min>0; min--) {
                if(less(arr[min], arr[min-1]))
                    swap(arr, min ,min-1);
                else break;
            }
        }
    }

    /**
     * Method to determine if one T value is less than another.
     *
     * @param v   the candidate element.
     * @param w   the comparand element.
     * @return true only if v is less than w.
     * Tips:
     * 1. If v > w,  v.compareTo(w) = 1
     * 2. If v == w,  v.compareTo(w) = 0
     * 3. If v < w, v.compareTo(w) = -1;
     */
    private boolean less(T v, T w) {
        // TO DO
        return v.compareTo(w) < 0;
    }

    public void swap(T[] arr, int i, int j) {
        swaps++;
        // TO DO
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
