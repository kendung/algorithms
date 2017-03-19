package intersection.linked.list;

import reverse.nodes.k.groups.ListNode;

/**
 * Created by xudeng on 3/18/17.
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
        {
            return null;
        }
        ListNode first = headA;
        ListNode second = headB;
        boolean firsttime = true;
        boolean firsttime2 = true;
        while(first != second)
        {
            if (first.next != null)
            {
                first = first.next;
            }else if (firsttime)
            {
                first = headB;
                firsttime = false;
            }else
            {
                first = first.next;
            }
            if (second.next != null)
            {
                second = second.next;
            }else if(firsttime2)
            {
                second = headA;
                firsttime2 = false;
            }else
            {
                second = second.next;
            }
        }

        if (first != null)
        {
            return first;
        }
        return null;
    }
}
