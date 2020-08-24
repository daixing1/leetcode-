package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/8/17
 * Time: 23:25
 * Description: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode res = head;
        int tmp = node.val;
        while (node.next != null) {
            if (tmp != node.next.val) {
                res.next = node.next;
                res = res.next;
                tmp = node.next.val;
            }
            node = node.next;
        }
        return head;
    }
}
