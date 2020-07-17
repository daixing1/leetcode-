package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/5/16
 * Time: 11:46
 * Description: 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *              k 是一个正整数，它的值小于或等于链表的长度。
 *              如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||k==1){
            return head;
        }
        int n = 1;
        ListNode node = head;
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        ListNode p = new ListNode(0);
        while (node.next!=null){
            node = node.next;
            n++;
            if (n==k){
                n=1;
                p = node.next;
                node.next = null;
                while (tmp.next!=null){
                    tmp = tmp.next;
                }
                tmp.next = reverseList(head);
                if (p==null){
                    break;
                }
                node = p;
                head = p;
            }
        }
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = p;
        return res.next;
    }

    public static ListNode reverseList(ListNode head){
        ListNode p = head;
        while (p.next!=null){
            p = p.next;
        }
        reverse(head.next,head);
        return p;
    }

    public static void reverse(ListNode node,ListNode pre){
        while (node.next!=null){
            reverse(node.next,node);
        }
        node.next = pre;
        pre.next = null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode node = reverseKGroup(node1, 2);
        System.out.println(node);
    }
}
