// LeetCode 146. LRU Cache
// using Java primitive types LinkedHashMap
package lrucache;

import java.util.LinkedHashMap;

public class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    
    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        // make key as latest used
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // modify the value of key
            cache.put(key, val);
            // make key as latest used
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // the head node of the list is least used element
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // add the new key into the end of list
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // delete the key, and insert into the end of the list
        cache.remove(key);
        cache.put(key, val);
    }
}
