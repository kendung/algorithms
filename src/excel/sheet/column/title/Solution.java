package excel.sheet.column.title;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudeng on 2/20/17.
 */
public class Solution {

    public String convertToTitle(int n) {

        if ( n >= 1 && n <= 26)
        {
            return String.valueOf(covertToChar(n));
        }
        List<Integer> result = new ArrayList<>();
        int temp = n;
        while(temp > 26)
        {
            int value = temp % 26;
            result.add(value);
            temp = Math.floorDiv(temp, 26);
        }
        result.add(temp);
        StringBuffer sb = new StringBuffer();
        if (n % 26 == 0)
        {
            sb.append('Z');
            boolean borrowbit = true;
            for(int i = 1; i < result.size(); i++)
            {
                if(result.get(i) != 0 && !borrowbit)
                {
                    sb.append(covertToChar(result.get(i)));
                }else if (result.get(i) == 0 && borrowbit)
                {
                    sb.append('Y');
                } else if (result.get(i) > 1 && borrowbit)
                {
                    sb.append(covertToChar(result.get(i) -1));
                    borrowbit = false;
                }else if (result.get(i) == 1 && borrowbit && i != result.size() -1)
                {
                    sb.append('Z');
                }
            }
            return sb.reverse().toString();
        }else
        {
            for(int i = result.size() -1; i >=0; i--)
            {
                sb.append(covertToChar(result.get(i)));
            }
            return sb.toString();
        }

    }

    // 1<=n<=26
    private char covertToChar(int n)
    {
        int value = (int)'A' + (n -1);
        char charvalue = (char)value;
        return charvalue;
    }



    public static void main (String[] args)
    {
        Solution main = new Solution();
        System.out.print(main.convertToTitle(18252));
    }

}
