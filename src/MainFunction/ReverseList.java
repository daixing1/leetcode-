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

    public static ListNode reverseList1(ListNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode node = head;
        ListNode pre = head.next;
        head = head.next;
        node.next=null;
        while (head.next!=null){
//            pre.next = null;
            head = head.next;
            pre.next = node;
            node = pre;
            pre = head;
        }
        pre.next = node;
        return pre;
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
        reverseList1(node1);
    }
}
