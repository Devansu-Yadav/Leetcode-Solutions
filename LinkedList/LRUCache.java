package LinkedList;
import java.util.HashMap;

// Idea is to use a HashMap to store a key and a corresponding LinkedList Node
// We use a Doubly Linked List where most recently used value is stored closer to head and 
// least recently used value is stored at its tail. Each time a key is accessed or set in the 
// HashMap, the corresponding Linked List node is moved towards head.

public class LRUCache {
    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
    }

    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode();
        this.head.prev = null;

        this.tail = new ListNode();
        this.tail.next = null;

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void addNode(ListNode node) {
        node.prev = this.head;
        node.next = this.head.next;

        this.head.next.prev = node;
        this.head.next = node;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(ListNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private ListNode popTail() {
        ListNode prev = this.tail.prev;
        this.removeNode(prev);
        return prev;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)) {
            ListNode node = this.map.get(key);
            
            this.moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)) {
            ListNode node = this.map.get(key);
            node.val = value;
            this.moveToHead(node);
        } else {
            if(this.map.size() == this.capacity) {
                ListNode tail = this.popTail();
                this.map.remove(tail.key);
            } 
            ListNode node = new ListNode();
            node.key = key;
            node.val = value;
            this.map.put(key, node);
            this.addNode(node);
        }
    }
}
