// LeetCode 460. LFU Cache
package lfucache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    // key to val mapping, called KV table
    private HashMap<Integer, Integer> keyToVal;
    // key to freq mapping, called KF table
    private HashMap<Integer, Integer> keyToFreq;
    // freq to key list mapping, called FK table
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // record smallest freq
    private int miniFreq;
    // record the max capacity of LFU
    private int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.miniFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // update the frequency of the key
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (this.cap <= 0) {
            return;
        }

        // if the key already existed
        // modify the val
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            // freq + 1
            increaseFreq(key);
            return;
        }

        // if the key doesn't exist
        // if the cash is full, remove the key with smallest freq
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        /* insert key and val, and its freq is 1 */
        // insert into KV table
        keyToVal.put(key, val);
        
        // insert into KF table, val is 1
        keyToFreq.put(key, 1);

        // insert into FK table
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // After a new key the smallest freq must be 1
        this.miniFreq = 1;
    }

    private void removeMinFreqKey() {
        // get the smallest freq list
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.miniFreq);
        // the first inserted key should be invalidated
        int deleteKey = keyList.iterator().next();
        /* update FK table */
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.miniFreq);
        }

        /* update KV table */
        keyToVal.remove(deleteKey);
        /* update KF table */
        keyToFreq.remove(deleteKey);

    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        /* update KF table */
        keyToFreq.put(key, freq + 1);

        /* update FK table */
        // remove the key based on freq
        freqToKeys.get(freq).remove(key);
        // add key into the freq + 1 list
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        // if freq list is empty, remove this freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // if this freq is the minFreq, update the minFreq
            if (freq == this.miniFreq) {
                this.miniFreq++;
            }
        }

    }
}
