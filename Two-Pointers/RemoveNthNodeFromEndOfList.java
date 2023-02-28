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

class RemoveNthNodeFromEndOfList {
    // T.C: O(N), Space Complexity: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev;
        ListNode current = head;

        // Count no of nodes in Linked List.
        int size = 1;
        while(current.next != null) {
            current = current.next;
            size++;
        }

        int posFromStart = size - n;
        if(posFromStart == 0) {
            prev = head;
            current = head.next;
            prev.next = null;
            return current;
        }

        prev = head;
        current = head.next;
        posFromStart--;
        while(posFromStart > 0) {
            prev = prev.next;
            current = current.next;
            posFromStart--;
        }

        // current points to node to be removed.
        prev.next = current.next;
        current.next = null;
        return head;
    }

    // T.C: O(N), Space Complexity: O(1)
    // Solves in one single pass (Sol for follow-up ques)
    public ListNode removeNthFromEndBetterSolution(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        // adjusting fast pointer to keep a gap of 'n' nodes between 
        // fast and slow pointers.
        while(n > 0) {
            fast = fast.next;
            n--;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == dummyNode) {
            // head node to be removed.
            slow = slow.next.next;
            return slow;
        }
        // else skip next node after slow.
        slow.next = slow.next.next;
        return head;
    }
}
