package Interleaving.string;

/**
 * Created by xudeng on 2/6/17.
 */
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        {
            return false;
        }
        if (s1.length() == 0)
        {
            if (s2.equals(s3))
            {
                return true;
            }else
            {
                return false;
            }
        }
        if (s2.length() == 0)
        {
            if (s1.equals(s3))
            {
                return true;
            }else
            {
                return false;
            }
        }
        char char1 = s1.charAt(0);
        char char2 = s2.charAt(0);
        char char3 = s3.charAt(0);
        if (char1 == char2)
        {
            if (char3 == char1)
            {
                return(
                        isInterleave(s1.substring(1),s2,s3.substring(1))
                        || isInterleave(s1, s2.substring(1), s3.substring(1))
                        );
            }else
            {
                return false;
            }
        }else
        {
            if (char1 == char3)
            {
                return (isInterleave(s1.substring(1), s2, s3.substring(1)));
            }else if (char2 == char3)
            {
                return (isInterleave(s1, s2.substring(1), s3.substring(1)));
            }else
            {
                return false;
            }
        }

    }
    public static void main(String args[])
    {
        Solution main = new Solution();
        System.out.println(main.isInterleave(
                "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                        "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                        "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
