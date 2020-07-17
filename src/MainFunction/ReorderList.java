package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/6/29
 * Time: 10:21
 * Description: 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *              将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *              你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null|head.next.next==null){
            return;
        }
        int count =0;
        ListNode tmp = head;
        while (tmp!=null){
            count++;
            tmp = tmp.next;
        }
        int rest = count%2==0?count/2+1:(count+1)/2;
        ListNode node = head;
        while (rest>0){
            node = node.next;
            rest--;
        }
        ListNode res = head;
        ListNode preRes = res;
        ListNode preNode = node;
        res = res.next;
        node = node.next;
        while (preRes!=null){
            preRes.next = preNode;
            preRes.next.next = res;
            preRes = res;
            res = res.next;
            preNode = node;
            node = node.next;
        }
    }
}
