package reverse.nodes.k.groups;

/**
 * Created by xudeng on 2/19/17.
 */
public class Solution {

    private ListNode[] stack;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
        {
            return null;
        }
        stack = new ListNode[k];
        ListNode newHead = null;
        ListNode tail = null;
        while(true)
        {
            boolean full = push(head, k);
            if (full)
            {
                if (newHead == null)
                {
                    newHead = stack[k-1];
                }
                head = stack[k-1].next;
                if (tail == null)
                {
                    tail = stack[0];
                    tail.next = null;
                }else
                {
                    tail.next = stack[k-1];
                    tail = stack[0];
                }
                for(int i = k-1; i >=0; i--)
                {
                    if ((i-1) >= 0)
                    {
                        stack[i].next = stack[i-1];
                    }else
                    {
                        stack[i].next = null;
                    }
                }
            }else
            {
                int size = size();
                if (newHead == null)
                {
                    return head;
                }
                if (size == 0)
                {
                    tail.next = null;
                }else
                {
                    tail.next = head;
                }
                break;
            }
            clear();
        }
        return newHead;
    }

    /**
     * return true, then size of the Stack should be k
     * return false, then size of the Stack should be small than k
     * @param head
     * @param k
     * @return
     */
    private boolean push(ListNode head, int k)
    {
        int i = 0;
        while(head != null && i < k)
        {
            stack[i] = head;
            i++;
            head = head.next;
        }
        if (i == k)
        {
            return true;
        }
        return false;
    }

    private void clear()
    {
        for(int i = 0; i < stack.length; i++)
        {
            stack[i] = null;
        }
    }

    private int size()
    {
        int size =0;
        for(int i = 0; i < stack.length; i++)
        {
            if (stack[i] != null)
            {
                size ++;
            }
        }
        return size;
    }

    public static void main(String[] args)
    {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        Solution main = new Solution();
        ListNode head = main.reverseKGroup(node1, 5);
        while(head != null)
        {
            if (head.next != null)
            System.out.print(head.val + "->");
            else
            System.out.print(head.val);
            head = head.next;
        }
    }
}
