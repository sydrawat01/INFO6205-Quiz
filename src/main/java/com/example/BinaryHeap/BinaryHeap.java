package com.example.BinaryHeap;

public class BinaryHeap {
    private int[] heap;
    private int N = 0;

    public BinaryHeap(int n){
        heap = new int[n];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(int v) throws FullException {
        if (N == heap.length) {
            throw new FullException();
        }
        heap[N] = v;
        swim(N++);
    }

    /* fixing the violation by exchanging the node with its parent.*/
    private void swim(int k){
        // TODO
        // k/2 is parent node
        while(k>0 && less(k/2,k)) {
            swap(k,k/2);
            k /= 2;
        }

    }

    public int delMax() throws EmptyException {
        if (N == 0) {
            throw new EmptyException();
        }
        int max = heap[0];

        swap(0, --N);
        heap[N] = 0;
        sink(0);
        return max;
    }

    private void sink(int k){
        // TODO
        //2k is left child, 2k+1 is right child
        while(2*k<=N) {
            int j = 2*k;
            if(j<N && less(j, j+1))
                j++;
            if(!less(k,j))
                break;
            swap(k,j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return heap[i] < heap[j];
    }

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int[] getHeap(){
        return heap;
    }
}
