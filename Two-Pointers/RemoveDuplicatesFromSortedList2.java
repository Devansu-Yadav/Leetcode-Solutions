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
    
    // T.C: O(N), Space Complexity: O(1)
    // Different approach: We keep a track of the last non-duplicate node by tracking previous 
    // and current node
    public static ListNode removeDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(101, head);
        ListNode i = dummyNode, prev = dummyNode;
        ListNode curr = head;

        while(curr != null) {
            while(curr != null && ((curr.next != null && curr.val == curr.next.val) || curr.val == prev.val)) {
                prev = curr;
                curr = curr.next;
            }

            i.next = curr;
            i = i.next;
            prev = curr;

            if(curr != null) {
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }
}
