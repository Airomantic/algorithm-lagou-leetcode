package N皇后2;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-27 16:15
 **/
public class Solution_queen {
    private int count = 0;
    public int totalNQueens(int n) {
        //递归函数本身是从上往下执行的，所以不需要保存第几行的数据
        boolean[] row = new boolean[n];//用于保存哪一列已经放置了棋子
        boolean[] left = new boolean[2 * n - 1];//用于保存哪一左斜排已经放置了棋子
        boolean[] right = new boolean[2 * n - 1];//用于保存哪一右斜排已经放置了棋子
        int[] num = new int[n];

        find(0, row, left, right, n, num);
        return count;
    }
    //i代表当前处理第几行，num记录了在第几行的第几个位置放了棋子
    private void find(int i, boolean[] row, boolean[] left, boolean[] right, int n, int[] num) {
        if (i == n) {//递归的末端
            count++;
            return;
        }
        for (int k = 0; k < n; k++) {
            if (!row[k] && !left[i + k] && !right[n - 1 - i + k]) {
                num[i] = k;//num不用回溯，因为在找到了解的前提下，num里的值肯定被重置过一遍了
                row[k] = true;
                left[i + k] = true;
                right[n - 1 - i + k] = true;//置位
                find(i + 1, row, left, right, n, num);
                row[k] = false;
                left[i + k] = false;
                right[n - 1 - i + k] = false;//回溯
            }
        }
        return;
    }
}
