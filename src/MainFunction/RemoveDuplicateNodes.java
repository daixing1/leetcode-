package MainFunction;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/5/23
 * Time: 15:04
 * Description: 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = new ListNode(0);
        ListNode res = node;
        node.next = head;
        while (node.next!=null){
            if (set.contains(node.next.val)){
                node.next = node.next.next;
                continue;
            }else {
                set.add(node.next.val);
                node = node.next;
                continue;
            }
        }
        return res.next;
    }
}
