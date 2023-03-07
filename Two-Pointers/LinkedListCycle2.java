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

// T.C: O(N), Space Complexity: O(N)
// Better Solution: https://leetcode.com/problems/linked-list-cycle-ii/solutions/44774/java-o-1-space-solution-with-detailed-explanation/comments/44281
class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode i = head;
        HashMap<ListNode, Integer> map = new HashMap<>();

        while(i != null) {
            if(map.containsKey(i)) {
                return i;
            }
            map.put(i, Integer.valueOf(i.val));
            i = i.next;
        }
        return null;
    }

    public ListNode detectCycleBetterSol(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                ListNode slow2 = head;
                while(slow2 != fast) {
                    // dist from head to beginning of cycle is equal to
                    // the dist from the meeting point of slow and fast pointers
                    // to the beginning of the cycle.
                    slow2 = slow2.next;
                    fast = fast.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
