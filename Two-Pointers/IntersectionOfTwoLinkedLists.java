// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// T.C: O(m + n), Space Complexity: O(1)
// Better/more concise Solution: https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/
class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int noOfNodesA = 1;
        int noOfNodesB = 1;

        ListNode i = headA;
        ListNode j = headB;

        // find no of nodes in list A
        while(i.next != null) {
            i = i.next;
            noOfNodesA++;
        }

        // find no of nodes in list B
        while(j.next != null) {
            j = j.next;
            noOfNodesB++;
        }

        i = headA;
        j = headB;

        if(i == j) {
            return headA;
        }

        while(i != null && j != null) {
            if(noOfNodesA > noOfNodesB) {
                i = i.next;
                noOfNodesA--;
            } else if(noOfNodesB > noOfNodesA) {
                j = j.next;
                noOfNodesB--;
            } else {
                i = i.next;
                j = j.next;
                noOfNodesA--;
                noOfNodesB--;
            }

            if(i == j) {
                return i;
            }
        }
        return null;
    }
}
