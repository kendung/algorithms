package remove.linked.list.elements;

import reverse.nodes.k.groups.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 3/19/17.
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        List<ListNode> cache = new ArrayList<>();
        while(head != null)
        {
            if (head.val != val)
            {
                cache.add(head);
            }
            head = head.next;
        }
        if(cache.size() == 0)
        {
            return null;
        }
        ListNode newhead = cache.get(0);
        for(int i = 0; i < cache.size(); i++)
        {
            ListNode node = cache.get(i);
            if (i + 1 < cache.size())
            {
                node.next = cache.get(i + 1);
            }else
            {
                node.next = null;
            }
        }
        return newhead;
    }
}
