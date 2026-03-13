// LeetCode 380. Insert Delete GetRandom O(1)
package insertdeletegetrandomo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    // store all values in a dynamic array for O(1) random access
    private final List<Integer> nums;

    // map each value to its index in num for O(1) look up
    private final Map<Integer, Integer> valToIndex;

    // random number generator for getRandom()
    private final Random rand;

    /** Initialize data structure */
    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
        rand = new Random();

    }

    /**
     * Insert a value to the set
     * @param val value to insert
     * @return true if the set did not already contain the specified element
     */
    public boolean insert(int val) {
        // if val already exists, do not insert
        if (valToIndex.containsKey(val)) {
            return false;
        }

        // append val to the end of nums
        nums.add(val);
        // record its index in the map
        valToIndex.put(val, nums.size() - 1);
        return true;
    }

    /**
     * Removes a val from the set.
     * @param val value to remove
     * @return true if the set contained the specified element
     */
    public boolean remove(int val) {
        // if val does not exist, nothing to move
        if (!valToIndex.containsKey(val)) {
            return false;
        }

        // get the index of val
        int indexToRemove = valToIndex.get(val);
        // get the last element in nums
        int lastElement = nums.get(nums.size() - 1);

        // move the last element to the position of val
        nums.set(indexToRemove, lastElement);
        // update the index of the moved element in the map
        valToIndex.put(lastElement, indexToRemove);

        // remove the last element (which is now a duplicate)
        nums.remove(nums.size() - 1);
        // remove val from the map
        valToIndex.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     * All elements must have the same probability of being returned.
     */
    public int getRandom() {
        // generate a random index and return the element at that index
        int randomIndex = rand.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
