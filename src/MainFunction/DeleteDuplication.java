package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/3/7
 * Time: 0:43
 * Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *              例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null||pHead.next == null){
            return pHead;
        }
        boolean flag = false;
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        ListNode node = pre;
        ListNode next = pHead.next;
        while(next!=null){
            if(pHead.val==next.val){
                pHead = next.next;
                next = pHead.next;
                pre.next = pHead;
                flag = true;
            }else{
                pHead = next;
                next = pHead.next;
                if (flag){
                    pre.next = pHead;
                }else {
                    pre = pre.next;
                }
                flag = false;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;
        node7.next = node4;
        node4.next = node5;
        deleteDuplication(node1);
    }
}
