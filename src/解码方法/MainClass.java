package 解码方法;

import jdk.nashorn.api.scripting.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-26 16:42
 **/
public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            int ret = new Solution_decode().numDecodings(s);
            String out = String.valueOf(ret);
            System.out.println(out);
        }
    }
//过滤掉null数据
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }
}
