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
class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(101);
        ListNode slow = dummy;
        ListNode fast = head;
        slow.next = head;

        while(fast != null) {
            while(fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }

            if(slow.next != fast) {
                // bunch of duplicate nodes b/w slow and fast
                slow.next = fast.next;
                fast = slow.next;
            } else {
                // else move both pointers
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
