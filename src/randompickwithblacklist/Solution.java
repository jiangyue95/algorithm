// LeetCode 710. Random Pick with Blacklist
package randompickwithblacklist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    // size of the valid range [0, sz)
    private final int sz;

    // map blacklisted numbers in [0, sz) to valid numbers in [sz, n)
    private final Map<Integer, Integer> mapping;

    // random number generator
    private final Random rand;

    public Solution(int n, int[] blacklist) {
        // total valid numbers = n - number of blacklisted numbers
        this.sz = n - blacklist.length;
        this.mapping = new HashMap<>();
        this.rand = new Random();

        // 1) mark all blacklisted numbers first
        for (int b : blacklist) {
            // use any placeholder value; we just care about the existing
            mapping.put(b, -1);
        }

        // 2) remap blacklisted numbers in [0, sz)
        int last = n - 1; // candidate from the upper range [sz, n)

        for (int b : blacklist) {
            // if b is already in the rang [sz, n), we don't need to remap it
            if (b >= sz) {
                continue;
            }

            // move 'last' backward until it points to a non-blacklisted number
            while (mapping.containsKey(last)) {
                last--;
            }

            // map this blacklisted number to a valid numer in [sz, n)
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        // pick a random number in [0, sz)
        int x = rand.nextInt(sz);

        // if x is blacklisted in [0, sz), return its mapped value
        if (mapping.containsKey(x)) {
            return mapping.get(x);
        }

        // otherwise, x itself is a valid (non-blacklisted) number
        return x;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
