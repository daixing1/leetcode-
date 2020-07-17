package MainFunction;

import DataStructure.ListNode;

import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/8
 * Time: 11:32
 * Description: 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 *              即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、
 *              5、6。这个链表的倒数第3个节点是值为4的节点。
 */
public class GetKthFromEnd {
    ListNode node = new ListNode(0);
    Integer n = null;
    public ListNode getKthFromEnd(ListNode head, int k) {
        findNode(head,k);
        return node.next;
    }

    public void findNode(ListNode head, int k){
        if (head.next!=null){
            findNode(head.next,k);
        }
        if (head.next==null){
            n = 0;
        }
        if (n!=null){
            n++;
        }
        if (n!=null&&n==k){
            node.next = head;
            return;
        }
    }

    public static void main(String[] args) {
        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        getKthFromEnd.getKthFromEnd(node1,2);
    }
}
