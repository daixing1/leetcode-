package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/5/1
 * Time: 9:53
 * Description: 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null||l2==null){
            return l1==null?l2:l1;
        }
        ListNode res = new ListNode(0);
        ListNode node = res;
        while (l1!=null&&l2!=null){
            if (l1.val>l2.val){
                node.next = l2;
                l2 = l2.next;
            }else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
            node.next = null;
        }
        node.next = l1==null?l2:l1;
        return res.next;
    }
}
