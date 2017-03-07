package remove.duplicate.from.sorted.list;

import reverse.nodes.k.groups.ListNode;

/**
 * Created by xudeng on 3/6/17.
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
        ListNode second = head.next;
        while(first != null && second != null)
        {
            if (first.val != second.val)
            {
                first = first.next;
                second = second.next;
            }else
            {
                // remove second
                first.next = second.next;
                second.next = null;
                second = first.next;
            }
        }
        return head;
    }
}
