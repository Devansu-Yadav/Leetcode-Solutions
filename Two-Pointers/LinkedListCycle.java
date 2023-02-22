// T.C: O(N), Space Complexity: O(N)
// Better Solution: https://leetcode.com/problems/linked-list-cycle/solutions/44694/accepted-clean-java-solution/

import java.util.HashMap;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode i = head;
        HashMap<ListNode, Integer> map = new HashMap<>();

        while(i != null) {
            if(map.containsKey(i)) {
                return true;
            }
            map.put(i, Integer.valueOf(i.val));
            i = i.next;
        }
        return false;
    }
}
