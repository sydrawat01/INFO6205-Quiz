package com.example.quiz7;

import org.junit.Test;
import org.junit.Assert;

public class Solution7Test {
    @Test
    public void testHappyFlow(){
        Solution7<String, Integer>  map = new Solution7<>(5);

        String[] keys = new String[]{"The", "Quick", "big", "Brown", "fox", "jumps", "over", "LAZY", "dog"};
        Integer[] values = new Integer[]{6, 10, 26, 328, 2215, 116, 1221, 3223, 5323};

        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        for(int i = 0; i < keys.length; i++){
            Assert.assertEquals(map.get(keys[i]), values[i]);
        }
        Assert.assertEquals(map.getSize(), 9);
    }

    @Test
    public void testSizeIncrements(){
        Solution7<String, Integer>  map = new Solution7<>(5);

        String[] keys = new String[]{"The", "Quick", "big", "Brown", "fox", "jumps", "over", "LAZY", "dog"};
        Integer[] values = new Integer[]{6, 10, 26, 328, 2215, 116, 1221, 3223, 5323};

        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
            Assert.assertEquals(map.getSize(), i+1);
        }
    }

    @Test
    public void testDuplicacy(){
        Solution7<String, Integer>  map = new Solution7<>(5);

        String[] keys = new String[]{"The", "Quick", "big", "Brown", "fox", "jumps", "over", "LAZY", "dog"};
        Integer[] values = new Integer[]{6, 10, 26, 328, 2215, 116, 1221, 3223, -5323};

        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        map.put("Quick", 9921);
        map.put("dog", -5323);
        map.put("Brown", 3731);
        map.put("big", -73941);
        Assert.assertEquals(map.getSize(), 9);
        Assert.assertEquals(map.get("Quick"), new Integer(9921));
        Assert.assertEquals(map.get("dog"), new Integer(-5323));
        Assert.assertEquals(map.get("Brown"), new Integer(3731));
        Assert.assertEquals(map.get("big"), new Integer(-73941));
    }

    @Test
    public void testCombine(){
        Solution7<String, Integer>  map = new Solution7<>(5);

        String[] keys = new String[]{"Is", "it", "difficult", "for", "you", "?"};
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] values2 = new Integer[]{4, 12, 63, 34, 25, 16};


        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }


        for(int i = 1; i < keys.length; i+=2){
            map.put(keys[i], values2[i]);
        }

        Integer[] expected = new Integer[]{1, 12, 3, 34, 5, 16};
        for(int i = 0; i < keys.length; i++){
            Assert.assertEquals(map.get(keys[i]), expected[i]);
        }
    }

    @Test
    public void testCollison(){
        Solution7<String, Integer>  map = new Solution7<>(10);

        String[] keys = new String[]{"br", "bro", "brown", "crown", "crowner", "brick", "bag", "fox"};
        Integer[] values = new Integer[]{6, 26, 328, 2215, 116, 1221, 3223, 5323};


        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        Assert.assertEquals(map.getSize(), 8);
        Integer[] expected = new Integer[]{6, 26, 328, 2215, 116, 1221, 3223, 5323};
        for(int i = 0; i < keys.length; i++){
            Assert.assertEquals(map.get(keys[i]), expected[i]);
        }
    }


    @Test
    public void testDelete(){
        Solution7<String, Integer>  map = new Solution7<>(10);

        String[] keys = new String[]{"br", "bro", "brown", "crown", "crowner", "brick", "bag", "fox"};
        Integer[] values = new Integer[]{6, 26, 328, 2215, 116, 1221, 3223, 5323};


        for(int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        Assert.assertEquals(map.getSize(), 8);
        Integer[] expected = new Integer[]{6, 26, 328, 2215, 116, 1221, 3223, 5323};
        for(int i = 0; i < keys.length; i++){
            if(i % 2 == 0){
                map.delete(keys[i]);
            }
        }

        for(int i = 0; i < keys.length; i++){
            if(i % 2 == 0){
                Assert.assertEquals(map.get(keys[i]), null);
            }
            else{
                Assert.assertEquals(map.get(keys[i]), values[i]);
            }
        }
    }
}
