/**
 * Definition for singly-linked list.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// T.C: O(N) -> Best case, when Linked List is sorted in ascending/descending order.
// O(N^2) (~similar to Insertion sort) in Worst case for unsorted List.
// Space Complexity: O(1), no extra space.
class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode first = new ListNode(head.val);
        ListNode last = first;

        ListNode j = head.next;
        while(j != null) {
            ListNode newNode = new ListNode(j.val);
            if(j.val <= first.val) {
                newNode.next = first;
                first = newNode;
            } else if(j.val >= last.val) {
                last.next = newNode;
                last = newNode;
            } else {
                ListNode ptr = first;
                while(ptr != last) {
                    if(j.val >= ptr.val && j.val <= ptr.next.val) {
                        newNode.next = ptr.next;
                        ptr.next = newNode;
                        break;
                    }
                    ptr = ptr.next;
                }
            }
            j = j.next;
        }
        return first;
    } 
}
