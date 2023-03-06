// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

// T.C: O(N), Space Complexity: O(1)
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(101);
        ListNode slow = dummy;
        ListNode prev = dummy;
        slow.next = head;

        ListNode fast = head;
        ListNode temp;
        
        while(fast != null) {
            while(fast.next != null && fast.val >= x) {
                prev = prev.next;
                fast = fast.next;
            }

            if(slow.next != fast && fast.val < x) {
                // couple of nodes greater than or equal to x
                // pushing smaller nodes at the beginning
                temp = fast.next;
                fast.next = slow.next;
                slow.next = fast;
                prev.next = temp;
                slow = slow.next;
                fast = temp;
            } else {
                prev = prev.next;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
