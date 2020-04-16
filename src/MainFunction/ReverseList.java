package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/3/2
 * Time: 23:19
 * Description: No Description
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode p = head;
        while (p.next!=null){
            p = p.next;
        }
        reverse(head.next,head);
        return p;

    }

    public static void reverse(ListNode node, ListNode pre){
        if (node.next!=null){
            reverse(node.next,pre.next);
        }
        node.next = pre;
        pre.next = null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseList(node1);
    }
}
