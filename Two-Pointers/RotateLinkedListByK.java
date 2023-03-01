// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
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
class RotateLinkedListByK {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null) {
            return head;
        }

        ListNode start = head;
        ListNode end = head;

        // counting no of nodes in linked list as well as positioning end
        // to point to the last node.
        int count = 1;
        while(end.next != null) {
            end = end.next;
            count++;
        }

        // Update value of k to determine how many times start pointer should move 
        // to point to the last node of final rotated linked list
        k = (count - 1) - (k % count);
        end.next = start;
        
        // moving start to point to the last node in the final rotated linked list
        while(k > 0) {
            start = start.next;
            k--;
        }

        head = start.next;
        start.next = null;
        return head;
    }
}
