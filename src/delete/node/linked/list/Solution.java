package delete.node.linked.list;

import reverse.nodes.k.groups.ListNode;

/**
 * Created by xudeng on 3/18/17.
 */
public class Solution {

    public void deleteNode(ListNode node) {

        if (node == null)
        {
            return;
        }
        ListNode first = node;
        ListNode second = node.next;
        while(second != null)
        {
            //copy value from second to first node
            first.val = second.val;
            if (second.next == null)
            {
                first.next = null;
                return;
            }else
            {
                first = first.next;
                second = second.next;
            }
        }

    }
}
