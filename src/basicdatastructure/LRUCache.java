// A LRU cache class
// LRU: Least Recently Used
package basicdatastructure;

import java.util.HashMap;

public class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // max capacity
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // left this element as the latest used
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            // delete old element
            deleteKey(key);
            // insert new element as the latest used element
            addRecently(key, val);
            return;
        }

        if (cap == cache.size()) {
            // delete the least used element
            removeLeastRecently();
        }
        // add element as the latest used element
        addRecently(key, val);
    }

    /* set a key as least recently used */
    private void makeRecently(int key) {
        Node x = map.get(key);
        // delete this node from DoubleList cache
        cache.remove(x);
        // add this node to last of DoubleList
        cache.addLast(x);
    }

    /* add recently used element */
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // The last node in the list is the recently used element
        cache.addLast(x);
        // add mapping in the HashMap
        map.put(key, x);
    }
    
    /* delete a key */
    private void deleteKey(int key) {
        Node x = map.get(key);
        // delete from list
        cache.remove(x);
        // delete from HashMap
        map.remove(key);
    }

    /* delete the least used element */
    private void removeLeastRecently() {
        // the head node of list is the least used element
        Node deletedNode = cache.removeFirst();
        // remove the key in the map
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }
}


class Node {
    public int key;
    public int val;

    public Node next;
    public Node prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}


class DoubleList {
    // virtual head and tail node
    private Node head;
    private Node tail;

    // size of elements
    private int size;

    public DoubleList() {
        // Initialize the data of DoubleList
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // Add element in end of list, time complexity is O(1)
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    // Delete node x in the list
    // Becasue it is a double linked list and taget is node
    // hence time complexity is O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // Delete a node in the list, and return this node
    // time complexity is O(1)
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }

        Node first = head.next;
        remove(first);
        return first;
    }

    // return the size of list
    // time complexity is O(1)
    public int size() {
        return size;
    }
}
