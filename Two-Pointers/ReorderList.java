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
class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev, temp;

        // after this loop, slow will be at middle, and fast will be at the end.
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the back-half of the list after slow using a three way-swap.
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while(slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // slow starts from end of linkedlist and fast starts from head.
        fast = head;
        slow = prev;
        while(slow != fast && slow.next != null) {
            temp = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            slow = temp;
            fast = fast.next.next;
        }
    }
}
