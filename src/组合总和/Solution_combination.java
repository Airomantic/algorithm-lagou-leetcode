package 组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-26 22:44
 **/
public class Solution_combination {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //集合中还有集合,如[[2,2,3],[2,5],[3,4],[7]]
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);//候选人，申请者
        find(listAll,list,candidates,target,0);
        return listAll;//返回所有子集
    }
    //tmp 终端监督程式
    public void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
        //递归终点
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        if (target<candidates[0]) return;
        //数组candidates[i]存放listAll的子集的不同元素，初始化num=0，之后num=i
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            //拷贝一份，不影响下次递归
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i);
        }
    }
}
