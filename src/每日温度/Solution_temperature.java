package 每日温度;

import java.util.Stack;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-24 17:48
 **/
public class Solution_temperature {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        //单调栈 里面的数 非递增排序
        Stack<Integer> stack = new Stack<>();
        //从后往前遍历
        for (int i = T.length - 1; i >= 0; i--) {
            // 当前元素比栈顶元素大 出栈 重新调整栈直至满足要求
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();//弹出
            }
            //栈为空 即后面没有比当前天温度高的
            // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            //当前元素进栈
            stack.push(i);
        }
        return res;
    }
}
