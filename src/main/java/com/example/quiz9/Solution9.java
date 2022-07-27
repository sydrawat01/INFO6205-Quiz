package com.example.quiz9;

public class Solution9 {
    /**
     * Rearranges the array of w-character strings in ascending order.
     *
     * @param a the array to be sorted
     * @param w the number of characters per string
     */
    public static void sort(String[] a, int w) {
        int n = a.length;
        int R = 256;   // extend ASCII alphabet size
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // 1. compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < n; i++)
                count[dthChar(a[i], d) + 1]++;

            // TODO

            // 2. compute cumulates
            for (int r=0; r<R; r++)
                count[r+1] += count[r];
            // 3. move data to aux array
            for (String s : a) aux[count[s.charAt(d)]++] = s;
            // 4. copy back from aux array to a
            System.arraycopy(aux, 0, a, 0, n);
        }
    }
    static char dthChar(String s, int d) {
        return s.charAt(d);
    }
}
