package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 10:32
 * Description: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 */
public class DeleteNode1 {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next!=null){
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }
}
