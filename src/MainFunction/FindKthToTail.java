package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/3/2
 * Time: 22:54
 * Description: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public static ListNode FindKthToTail(ListNode head,int k) {
            ListNode p = head;
            while(k--!=0&&p!=null){
                p = p.next;
            }
            if(p==null){
                if(k==-1){
                    return head;
                }else{
                    return null;
                }
            }
            while(p!=null){
                p = p.next;
                head = head.next;
            }
            return head;

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
        FindKthToTail(node1,5);
    }
}
