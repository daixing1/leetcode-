package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/5/20
 * Time: 22:00
 * Description: 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *              返回删除后的链表的头节点
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode res = new ListNode(0);
        ListNode pre = res;
        res.next = head;
        while (head!=null){
            if (head.val==val){
                pre.next = head.next;
                break;
            }else {
                head = head.next;
                pre = pre.next;
            }
        }
        return res.next;
    }
}
