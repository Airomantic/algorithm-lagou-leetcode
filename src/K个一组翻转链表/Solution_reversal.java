package K个一组翻转链表;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: leetcode-lagou
 * @description:
 * @author: jiangzq
 * @create: 2019-10-24 15:34
 **/
public class Solution_reversal {
    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);//节点虚设dummy
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;//下一个指针指向它的头节点
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pollLast();
//offerLast(element)指定元素添加在列表的末尾，pollLast()返回列表的最后一个元素并从列表中移除
                p = p.next;//把移除的元素保存下来
            }
            p.next = tmp;//指针调换
            head = tmp;
        }
        return dummy.next;
    }
}
