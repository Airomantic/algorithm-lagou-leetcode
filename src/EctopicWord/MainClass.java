package EctopicWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-24 11:34
 **/
public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine())!=null) {
            String s = stringToString(line);
            line = in.readLine();
            String t = stringToString(line);
            boolean ret = new Solution().isAnagram(s, t);
        }
    }
}
