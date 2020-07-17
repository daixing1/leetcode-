package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/4/20
 * Time: 10:42
 * Description: No Description
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null){
            return null;
        }
        while (head.val==val){
            head = head.next;
        }
        ListNode res = head;
        ListNode pre = head;
        ListNode next = head.next;
        while (next!=null){
            if (next.val==val){
                pre.next = next.next;
                next = next.next;
            }else {
                pre = pre.next;
                next = next.next;
            }
        }
        return res;
    }
}
