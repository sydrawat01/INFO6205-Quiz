package com.example.quiz9;

import org.junit.Test;
import org.junit.Assert;

public class Solution9Test {
    @Test
    public void testEmptyStrings() {
        String[] strings = new String[] {};
        Solution9.sort(strings, 0);
        Assert.assertEquals(new String[] {}, strings);
    }

    @Test
    public void testReverseString() {
        String[] strings = new String[] {"c", "b", "a"};
        Solution9.sort(strings, strings[0].length());
        Assert.assertEquals(new String[] {"a", "b", "c"}, strings);
    }

    @Test
    public void testOrderedString() {
        String[] strings = new String[] {"ab", "ac", "bb", "cc"};
        Solution9.sort(strings, strings[0].length());
        Assert.assertEquals(new String[] {"ab", "ac", "bb", "cc"}, strings);
    }

    @Test
    public void testPartialOrderString() {
        String[] strings = new String[] {"bb", "ac", "bc", "cc"};
        Solution9.sort(strings, strings[0].length());
        Assert.assertEquals(new String[] {"ac", "bb", "bc", "cc"}, strings);
    }

    @Test
    public void testDuplicateString() {
        String[] strings = new String[] {"bcb", "acb", "bbc", "scc", "bcw", "abc", "bbc"};
        Solution9.sort(strings, strings[0].length());
        Assert.assertEquals(new String[] {"abc", "acb", "bbc", "bbc", "bcb", "bcw", "scc"}, strings);
    }
}
