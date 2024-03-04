package LinkedList;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// T.C: O(N), Space Complexity: O(N)
// Better Optimized Solution: https://leetcode.com/problems/copy-list-with-random-pointer/solutions/43491/a-solution-with-constant-space-complexity-o-1-and-linear-time-complexity-o-n/
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        return copyList(head);
    }

    public static Node copyList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node ptr = head;

        while(ptr != null) {
            map.put(ptr, new Node(ptr.val));
            ptr = ptr.next;
        }

        ptr = head;
        while(ptr != null) {
            map.get(ptr).next = map.get(ptr.next);
            map.get(ptr).random = map.get(ptr.random);
            ptr = ptr.next;
        }

        return map.get(head);
    }
}
