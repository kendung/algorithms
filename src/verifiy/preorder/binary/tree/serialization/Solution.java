package verifiy.preorder.binary.tree.serialization;


import java.util.regex.Pattern;

/**
 * Created by xudeng on 3/11/17.
 */
public class Solution {

    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#"))
        {
            return true;
        }
        String regularExpression = "\\d+,#,#";
        Pattern pattern = Pattern.compile(regularExpression);
        if (!pattern.matcher(preorder).find())
        {
            return false;
        }
        while(pattern.matcher(preorder).find())
        {
            preorder = preorder.replaceFirst(regularExpression, "#");
        }
        if (preorder.equals("#"))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Solution main = new Solution();
        System.out.print(main.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
