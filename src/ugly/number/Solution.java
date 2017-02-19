package ugly.number;

/**
 * Created by xudeng on 2/18/17.
 */
public class Solution {

    public boolean isUgly(int num) {
        if(num==1) return true;
        if(num<=0) return false;
        while(num%2==0) num=num/2;
        while(num%3==0) num=num/3;
        while(num%5==0) num=num/5;
        return num==1;
    }


    public static void main(String [] args)
    {
        Solution main = new Solution();
        System.out.print(main.isUgly(937351770));
    }
}
