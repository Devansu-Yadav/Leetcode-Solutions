public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // Using Bubble Sort, TC: O(N^2), Space Complexity: O(1)
    public static ListNode bubbleSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        boolean sorted = false;
        boolean swapped = false;

        while(!sorted) {
            swapped = false;
            ListNode i = null;
            ListNode j = head;
            while(j.next != null) {
                ListNode temp = j.next;

                if(j.val > temp.val) {
                    temp.next = j;
                    j.next = temp.next;

                    if(i != null) {
                        i.next = temp;
                    }
                    swapped = true;
                    i = temp;
                } else {
                    if(i == null) {
                        i = j;
                    } else {
                        i = i.next;
                    }
                    j = j.next;
                }
            }

            if(!swapped) {
                sorted = true;
            }
        }
        return head;
    }

    // Using Merge Sort, TC: O(NlogN), Space Complexity: O(logN)
    public static ListNode merge(ListNode h1, ListNode h2) {
        if(h1 == null) {
            return h2;
        }

        if(h2 == null) {
            return h1;
        }

        if(h1.val < h2.val) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    } 

    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode l = head;
        ListNode r = head;
        ListNode prev = head;

        while(r != null && r.next != null) {
            prev = l;
            l = l.next;
            r = r.next.next;
        }

        prev.next = null;

        ListNode h1 = mergeSort(head);
        ListNode h2 = mergeSort(l);
        return merge(h1, h2);
    }
}
