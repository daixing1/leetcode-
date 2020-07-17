package MainFunction;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;


/**
 * User: 兴希
 * Date: 2020/6/5
 * Time: 10:00
 * Description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(list.size()-1-i);
        }
        return res;
    }
}
