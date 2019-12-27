package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2019/12/26
 * Time: 20:49
 * Description: No Description
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode head = resultNode;
        ListNode pre = new ListNode(0);
        if (l1==null|| l2==null){
            resultNode=l1==null?l2:l1;
            return resultNode;
        }
        int count = 0;
        while (l1!=null&&l2!=null){
            int sum = l1.val+l2.val;
            resultNode.val = sum%10 + count;
            ListNode node = new ListNode(0);
            pre = resultNode;
            resultNode.next = node;
            resultNode = resultNode.next;
            if (sum>=10){
                count = 1;
            }else {
                count=0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1==null){
            pre.next = l2;
        }else if (l2==null){
            pre.next = l1;
        }
        if (count==1){
            ListNode node = new ListNode(0);
            node = pre.next;
            while (node!=null&&node.val==9){
                node.val=0;
                node = node.next;
            }
            if (node!=null){
                node.val+=1;
            }else {
                ListNode node1 = new ListNode(1);
                pre.next = node;
            }

        }else {
            pre.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
//        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(0);
//        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(4);
        node1.next = node2;
//        node2.next = node3;
//        node4.next = node5;
//        node5.next = node6;
        ListNode node = addTwoNumbers(node1, node4);
        System.out.println(node);
    }
}
