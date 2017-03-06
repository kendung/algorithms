package wordbreak;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xudeng on 2/21/17.
 */
public class Solution {

    private List<String> intermediateResult = new ArrayList<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s))
        {
           return true;
        }else
        {
            return backtracking(s, wordDict);
        }
    }

    private boolean backtracking(String s, List<String> wordDict)
    {
        if (intermediateResult.contains(s))
        {
            return true;
        }
        if (s.equals("") || wordDict.contains(s))
        {
            return true;
        }
        Iterator<String> it = wordDict.iterator();
        while(it.hasNext())
        {
            String wordCandidate = it.next();
            int firstIndex = s.indexOf(wordCandidate);
           if (firstIndex != -1)
           {
               int lastIndex = s.length() - wordCandidate.length();
               for(int i = firstIndex; i <= lastIndex; i++)
               {
                   int occurIndex = s.indexOf(wordCandidate, i);
                   if(occurIndex != -1)
                   {
                       String leftSubstring = s.substring(0,occurIndex);
                       boolean left = backtracking(leftSubstring, wordDict);
                       if (left && !intermediateResult.contains(leftSubstring))
                       {
                           intermediateResult.add(leftSubstring);
                       }
                       String rightSubstring = s.substring(occurIndex + wordCandidate.length());
                       boolean right = backtracking(rightSubstring, wordDict);
                       if (right && !intermediateResult.contains(rightSubstring))
                       {
                           intermediateResult.add(rightSubstring);
                       }
                       if (left && right)
                       {
                           return true;
                       }
                   }else
                   {
                       break;
                   }
               }
           }
        }
        return false;
    }

    public static void main(String[]args)
    {
        Solution main = new Solution();
        List<String> words = new ArrayList<String>();
        words.add("cc");
        words.add("bc");
        words.add("ac");
        words.add("ca");
        words.add("c");
        words.add("b");
        System.out.print(main.wordBreak("cccccccccbbbbbbb", words));
    }
}
