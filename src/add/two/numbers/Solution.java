package add.two.numbers;

import reverse.nodes.k.groups.ListNode;

/**
 * Created by xudeng on 3/23/17.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
        {
            return l2;
        }
        if (l2 == null)
        {
            return l1;
        }
        ListNode sumNode = null;
        ListNode newHeader = null;
        boolean carrybit = false;
        while(l1 != null && l2 != null)
        {
            int a = l1.val;
            int b = l2.val;
            int sum = a + b;
            if (carrybit)
            {
                sum++;
            }
            ListNode temp = null;
            if (sum < 10)
            {
                carrybit = false;
                temp = new ListNode(sum);
                temp.next = null;
            }else
            {
                carrybit = true;
                temp = new ListNode(sum - 10);
                temp.next = null;
            }
            if (newHeader == null)
            {
                newHeader = temp;
                sumNode = newHeader;
            }else
            {
                sumNode.next = temp;
                sumNode = temp;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remaining = null;
        if (l1 != null)
        {
            remaining = l1;
        }else
        {
            remaining = l2;
        }
        if (remaining == null)
        {
            if (carrybit)
            {
                ListNode temp = new ListNode(1);
                temp.next = null;
                sumNode.next = temp;
            }
        }else
        {
            if (!carrybit)
            {
                sumNode.next = remaining;
            }else
            {
                sumNode.next = remaining;
                while(remaining != null)
                {
                    int sumtemp = remaining.val;
                    if (carrybit)
                    {
                        sumtemp = sumtemp + 1;
                    }
                    if (sumtemp < 10)
                    {
                        remaining.val = sumtemp;
                        carrybit = false;
                        break;
                    }else
                    {
                        carrybit = true;
                        remaining.val = sumtemp - 10;
                        sumNode = remaining;
                        remaining = remaining.next;
                    }
                }
                if (carrybit)
                {
                    ListNode fuck = new ListNode(1);
                    fuck.next = null;
                    sumNode.next = fuck;
                }
            }
        }
        return newHeader;
    }
}
