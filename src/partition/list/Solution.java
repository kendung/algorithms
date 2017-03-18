package partition.list;

import reverse.nodes.k.groups.ListNode;

/**
 * Created by xudeng on 3/17/17.
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {

        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode largeHead = null;
        ListNode largeTail = null;

        while(head != null)
        {
            if (head.val < x)
            {
                if (smallHead == null)
                {
                    smallHead = head;
                    smallTail = head;
                }else
                {
                    smallTail.next = head;
                    smallTail = head;
                }
            }else
            {
               if (largeHead == null)
               {
                   largeHead = head;
                   largeTail = head;
               }else
               {
                   largeTail.next = head;
                   largeTail = head;
               }
            }
            head = head.next;
        }
        if (smallHead != null && largeHead != null)
        {
            smallTail.next = largeHead;
            largeTail.next = null;
            return smallHead;
        }else if (smallHead != null && largeHead == null)
        {
            smallTail.next = null;
            return smallHead;
        }else if (smallHead == null && largeHead != null)
        {
            largeTail.next = null;
            return largeHead;
        }
        return null;
    }
}
