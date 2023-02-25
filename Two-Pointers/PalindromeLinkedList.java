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

// T.C: O(N), Space Complexity: O(N)
// Better Solution: https://leetcode.com/problems/palindrome-linked-list/solutions/1137027/js-python-java-c-easy-floyd-s-reversal-solution-w-explanation/
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode j = new ListNode(head.val);
        ListNode i = head.next;

        // Creating a new linked list which is reverse of the original one.
        while(i != null) {
            ListNode newNode = new ListNode(i.val, j);
            j = newNode;
            i = i.next;
        }

        // Running one pointer through original linked list and 
        // second pointer through reversed linked list
        i = head;
        while(i != null) {
            if(i.val != j.val) {
                return false;
            }
            i = i.next;
            j = j.next;
        }
        return true;
    }
}
