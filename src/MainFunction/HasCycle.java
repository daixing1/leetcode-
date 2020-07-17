package MainFunction;

import DataStructure.ListNode;
import DataStructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 21:32
 * Description: 给定一个链表，判断链表中是否有环。
 *              为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *              如果 pos 是 -1，则在该链表中没有环。
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return false;
            }
            set.add(head);
            head = head.next;
        }
        return true;
    }
}
