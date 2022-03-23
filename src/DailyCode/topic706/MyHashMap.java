package DailyCode.topic706;

import java.util.*;

public class MyHashMap {
    int[] nums;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nums = new int[1000000];
        Arrays.fill(nums,-99999999);
        Math.abs(1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        nums[key]=value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (nums[key]==-99999999){
            return -1;
        }else return nums[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        nums[key]=-99999999;
    }
}
