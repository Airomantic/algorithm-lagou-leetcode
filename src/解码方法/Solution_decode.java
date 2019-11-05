package 解码方法;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-26 16:56
 **/
public class Solution_decode {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return recursion(s, 0);//递归函数
    }

    //递归的套路，加一个index控制递归的层次
    private int recursion(String s, int start) {
        //递归的第一步，应该是加终止条件，避免死循环。
        if (s.length() == start) {
            return 1;
        }
        //以0位开始的数是不存在的
        if (s.charAt(start) == '0') {
//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
            return 0;
        }
        //递归的递推式应该是如果index的后两位小于等于26，
        // recursion(s, start) = recursion(s, start+1)+recursion(s, start+2)
        // 否则recursion(s, start) = recursion(s, start+1)
        int ans1 = recursion(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ans2 = recursion(s, start + 2);
            }
        }
        return ans1 + ans2;
    }
}
