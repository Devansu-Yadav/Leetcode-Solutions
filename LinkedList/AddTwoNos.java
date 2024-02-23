package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// T.C: O(N), Space Complexity: O(1)
public class AddTwoNos {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNos(l1, l2);
    }

    public static ListNode addNos(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        } else if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode ptr1 = l1, ptr2 = l2;
        ListNode out = new ListNode(-1);
        ListNode outHead = out;

        while(ptr1 != null && ptr2 != null) {
            int sum = ptr1.val + ptr2.val + carry;
            out.next = new ListNode(0);
            out = out.next;
            out.val = sum % 10;
            carry = sum / 10;
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while(carry == 0 && ptr1 != null) {
            out.next = new ListNode(ptr1.val);
            out = out.next;
            ptr1 = ptr1.next;
        }

        while(carry == 0 && ptr2 != null) {
            out.next = new ListNode(ptr2.val);
            out = out.next;
            ptr2 = ptr2.next;
        }

        while(ptr1 != null) {
            int sum = ptr1.val + carry;
            out.next = new ListNode(0);
            out = out.next;
            out.val = sum % 10;
            carry = sum / 10;

            ptr1 = ptr1.next;
        }

        while(ptr2 != null) {
            int sum = ptr2.val + carry;
            out.next = new ListNode(0);
            out = out.next;
            out.val = sum % 10;
            carry = sum / 10;

            ptr2 = ptr2.next;
        }

        if(carry > 0) {
            out.next = new ListNode(0);
            out = out.next;
            out.val = carry;
        }

        return outHead.next;
    }
}
