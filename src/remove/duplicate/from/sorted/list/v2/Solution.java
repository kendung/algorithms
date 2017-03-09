package remove.duplicate.from.sorted.list.v2;

import reverse.nodes.k.groups.ListNode;

/**
 * Created by xudeng on 3/8/17.
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
        {
            return null;
        }
        if (head.next == null)
        {
            return head;
        }
        ListNode first = head;
        ListNode next = head.next;
        ListNode previous = null;
        while(first != null && next != null)
        {
            if (first.val != next.val)
            {
                if (previous == null)
                {
                    if (first.next != next)
                    {
                        first = next;
                        next = next.next;
                        if (next == null)
                        {
                            return first;
                        }
                    }else
                    {
                        head = first;
                        previous = first;
                        first = first.next;
                        next = next.next;
                    }
                }else
                {
                    if (first.next != next)
                    {
                        previous.next = next;
                    }else {
                        previous = first;
                    }
                    first = next;
                    next = next.next;
                }
            }else
            {
                next = next.next;
            }
        }
        if (previous == null)
        {
            return null;
        }else
        {
            if (first.next != null)
            previous.next = next;
        }
        return head;
    }
}
