package 滑动窗口最大值;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-24 21:19
 **/
public class Solution_max {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0) {
            return nums;
        }
        //返回数组的长度
        int num = nums.length - k + 1;
        int[] arr = new int[num];//承载滑动中的最大值
        int maxIndex = -1;//最大数的下标
        for (int i = 0; i < num; i++) {
            if (maxIndex >= i && maxIndex < i + k) {
                arr[i] = nums[maxIndex];
            } else {
                //找出当前窗口最大的下标
                maxIndex = i;
                for (int j = i; j < i + k; j++) {
                    if (nums[maxIndex] <= nums[j]) {
                        maxIndex=j;//在这个窗口进行比较
                    }
                }
                arr[i] = nums[maxIndex];
            }
            if (i + k < nums.length) {
                //和下一个将要进入窗口的数比较
                if (nums[maxIndex] <= nums[i + k]) {
                    maxIndex = i + k;
                }
            }
        }
        return arr;
    }
}
