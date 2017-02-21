package valid.parentheses;

import java.util.Stack;

/**
 * Created by xudeng on 2/20/17.
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++)
        {
            char element = s.charAt(i);
            if (element == '(' || element == '{' || element == '[')
            {
                stack.push(element);
            }else if (!stack.isEmpty())
            {
                char topelement = stack.peek();
                if (element == ')' && topelement != '(')
                {
                    return false;
                }else if (element == '}' && topelement != '{')
                {
                    return false;
                }else if (element == ']' && topelement != '[')
                {
                    return false;
                }
                stack.pop();
            }else
            {
                return false;
            }
        }
        if (stack.isEmpty())
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Solution main = new Solution();
        System.out.print(main.isValid("abc"));
    }
}
