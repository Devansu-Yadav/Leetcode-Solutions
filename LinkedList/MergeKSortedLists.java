package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

// T.C: O(k*(l1+l2+l3)), S.C: O(k)
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLinkedLists(lists);
    }

    public static ListNode mergeLinkedLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(-1);
        ListNode ptr = dummyNode;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
            }
        });

        for(ListNode l: lists) {
            if(l != null) {
                pq.offer(l);
            }
        }

        while(pq.size() != 0) {
            ListNode node = pq.poll();
            ptr.next = new ListNode(node.val);
            ptr = ptr.next;

            if(node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummyNode.next;
    }
}
