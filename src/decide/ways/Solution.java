package decide.ways;

/**
 * Created by xudeng on 1/31/17.
 */
public class Solution {

    private int[] intermediateResult;

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        intermediateResult = new int[s.length() + 1];
        if (s.length() == 1) {
            if (s.equals("0"))
                return 0;
            else
                return 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (i == 1) {
                String substring = s.substring(0, 1);
                if (substring.equals("0")) {
                    intermediateResult[i] = 0;
                } else {
                    intermediateResult[i] = 1;
                }
            } else if (i == 2) {
                char first = s.charAt(i - 2);
                char second = s.charAt(i - 1);
                if (first == '0') {
                    if (second == '0') {
                        intermediateResult[i] = 0;
                    } else {
                        intermediateResult[i] = 1;
                    }
                } else {
                    String substring = s.substring(0, 2);
                    if (Integer.parseInt(substring) <= 26) {
                        intermediateResult[i] = 2;
                    } else {
                        intermediateResult[i] = 1;
                    }
                }
            } else {
                String substring = s.substring(i - 2, i);
                char first = s.charAt(i-2);
                char second = s.charAt(i-1);
                if (first == '0') {
                    if (second == '0')
                    {
                        intermediateResult[i] = intermediateResult[i-1];
                    }else
                    {

                    }
                }
                if (Integer.parseInt(substring) <= 26) {
                    intermediateResult[i] = intermediateResult[i - 1] + i - 2;
                } else {
                    intermediateResult[i] = intermediateResult[i - 1];
                }
            }
        }
        return intermediateResult[s.length()];
    }

    public static void main(String args[]) {
        Solution main = new Solution();
        System.out.println(main.numDecodings("1212"));
    }
}
