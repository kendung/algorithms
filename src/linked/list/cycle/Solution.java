package linked.list.cycle;

import reverse.nodes.k.groups.ListNode;

/**
 * Created by xudeng on 3/18/17.
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
        {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast && fast != null)
        {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
            {
                return false;
            }
            fast = fast.next;
        }
        if (fast == null)
        {
            return false;
        }else
        {
            return true;
        }
    }
}
