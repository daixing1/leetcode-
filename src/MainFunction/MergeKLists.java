package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/4/26
 * Time: 10:35
 * Description: 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        ListNode res = new ListNode(lists[0].val);
        ListNode head = res;
        boolean flag = true;
        while (flag) {
            flag = false;
            ListNode node = new ListNode(Integer.MAX_VALUE);
            int pos = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    flag = true;
                    if (lists[i].val < node.val) {
                        node.val = lists[i].val;
                        pos = i;
                    }
                }
            }
            if (flag) {
                lists[pos] = lists[pos].next;
                res.next = node;
                node.next = null;
                res = res.next;
            }
        }
    return head.next;

    }


}
