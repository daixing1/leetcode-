package MainFunction;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

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
        if (l1==null|| l2==null){
            resultNode=l1==null?l2:l1;
            return resultNode;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Integer count = 0;
        while (l1!=null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            list2.add(l2.val);
            l2 = l2.next;
        }
        Integer length = Math.max(list1.size(),list2.size());
        for (int i=0;i<length;i++){
            Integer n=0;
            if (list1.size()-1-i>=0&&list2.size()-1-i>=0){
                n = list1.get(list1.size()-1-i)+list2.get(list2.size()-1-i);
            } else if (list1.size()-1-i>=0&&list2.size()-1-i<0){
                n = list1.get(list1.size()-1-i);
            } else if (list1.size()-1-i<0&&list2.size()-1-i>=0){
                n = list2.get(list2.size()-1-i);
            }
            result.add((n+count)%10);
            if (n+count>=10){
                count = 1;
            }else {
                count = 0;
            }
        }
        if (count==1){
            result.add(1);
        }
        for (int i=result.size();i>0;i--){
            ListNode node = new ListNode(result.get(i-1));
            resultNode.next = node;
            resultNode = resultNode.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node6.next = node7;
//        node5.next = node6;
        ListNode node = addTwoNumbers(node5, node5);
        System.out.println(node);
    }
}
