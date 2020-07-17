package MainFunction;

import DataStructure.ListNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 11:01
 * Description: 请判断一个链表是否为回文链表。
 */
public class IsPalindromeList implements Serializable {
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null){
            return true;
        }
        int len = 0;
        ListNode node = head;
        while (node!=null){
            len++;
            node = node.next;
        }
        int left = 0;
        ListNode listNode = head;
        while (listNode!=null){
            left++;
            if (left==len/2){
                break;
            }
            listNode = listNode.next;

        }
        ListNode right = listNode.next;
        listNode.next = null;
        reverse(head);
        if (len%2!=0){
            right = right.next;
        }
        while (right!=null){
            if (right.val!=listNode.val){
                return false;
            }else {
                right = right.next;
                listNode = listNode.next;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode node){
        if (node==null||node.next==null){
            return node;
        }
        ListNode reverse = reverse(node.next);
        node.next = null;
        reverse.next = node;
        reverse = reverse.next;
        return reverse;
    }

    public static void main(String[] args) {
        IsPalindromeList isPalindromeList = new IsPalindromeList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(-1);
        ListNode listNode4 = new ListNode(-1);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        boolean palindrome = isPalindromeList.isPalindrome(listNode1);
        System.out.println(palindrome);
    }
}
