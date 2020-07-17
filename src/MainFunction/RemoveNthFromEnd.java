package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 21:20
 * Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null||head.next==null){
            return null;
        }
        int count = 0;
        ListNode node = head;
        while (node!=null){
            count++;
            node = node.next;
        }
        if (count==n){
            return head.next;
        }
        int index = 0;
        ListNode listNode = head;
        while (listNode!=null){
            index++;
            if (index==count-n){
                listNode.next = listNode.next.next;
                return head;
            }else {
                listNode = listNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode node = removeNthFromEnd.removeNthFromEnd(node1,2);
        System.out.println();
    }
}
