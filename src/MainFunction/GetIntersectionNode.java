package MainFunction;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/15
 * Time: 10:15
 * Description: 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
