package N皇后2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-27 16:08
 **/
public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            int ret = new Solution_queen().totalNQueens(n);
            String out = String.valueOf(ret);
            System.out.println(out);
        }
    }
}
