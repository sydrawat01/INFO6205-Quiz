package com.example.quiz7;

public class Solution7<Key, Value> {
    private int N; // number of key-value pairs in the table
    private int M; // size of linear-probing table
    private Key[] keys; // the keys
    private Value[] vals; // the values

    public Solution7(int cap) {
        M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return N;
    }

    private void resize(int cap) {
        Solution7<Key, Value> t;
        t = new Solution7<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val) {
        //TODO: Insert the key-value pair(double M)
        if(key == null) throw new IllegalArgumentException("first parameter @ put() is null");
        if(val == null){
            delete(key);
            return;
        }

        // double size if 50% full
        if (N >= M/2)
            resize(2*M);

        int i;
        for(i=hash(key); keys[i] != null; i=(i+1)%M){
            if(keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        //TODO: Return value for specified key
        if (key == null) throw new IllegalArgumentException("parameter @ get() is null");
        for(int i=hash(key); keys[i] != null; i=(i+1)%M){
            if(key.equals(keys[i]))
                return vals[i];
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key)
    {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null)
        {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }
}