package 组合总和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-26 22:30
 **/
public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] candidates = stringToIntegerArray(line);
            //输入新的数target
            line = in.readLine();
            int target = Integer.parseInt(line);
            List<List<Integer>> ret = new Solution_combination().combinationSum(candidates, target);
            String out = int2dListToString(ret);
            System.out.println(out);
        }
    }

    private static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (List<Integer> list : nums) {//其实这个nums就是listAll
            //一个List<>分离各个子集[[],[],[],[]]
            stringBuilder.append(integerArrayListToString(list));
//append方法就是将字符串追加到当前StringBuilder实例的结尾,即“[],”在每个子集后加一个“,”
            stringBuilder.append(",");
        }
            //尾部的字符，如[2,2,3]的“3]”结束
        stringBuilder.setCharAt(stringBuilder.length()-1,']');
        return stringBuilder.toString();
    }

    private static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    private static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            //整型转字符,如[[],[],[],[]]中[],[],[]之间的“,”添加上
            result += Integer.toString(number)+",";
        }
        return "[" + result.substring(0, result.length() -1) + "]";
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);//逐个传入修整好的数
        }
        return output;
    }
}
