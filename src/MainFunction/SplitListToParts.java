package MainFunction;

import DataStructure.ListNode;

/**
 * User: 兴希
 * Date: 2020/6/27
 * Time: 10:12
 * Description: 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *              每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *              这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *              返回一个符合上述规则的链表的列表。
 *              举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 */
public class SplitListToParts {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int count = 0;
        ListNode node = root;
        while (node!=null){
            count++;
            node = node.next;
        }
        if (count<=k){
            for (int i=0;i<k;i++){
                if (root!=null){
                    res[i] = root;
                    root = root.next;
                    res[i].next = null;

                }else {
                    res[i] = null;
                }
            }
        }else {
            int n = count/k;
            int m = count%k;
            for (int i=0;i<k;i++){
                ListNode listNode = new ListNode(0);
                ListNode tmpres = listNode;
                if (i<m){
                    for (int j=0;j<n+1;j++){
                        listNode.next = root;
                        listNode = listNode.next;
                        root = root.next;
                    }
                }else {
                    for (int j=0;j<n;j++){
                        listNode.next = root;
                        listNode = listNode.next;
                        root = root.next;
                    }
                }
                listNode.next = null;
                res[i] = tmpres.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
        node9.next = node10;
//        node10.next = node11;

        ListNode[] listNodes = splitListToParts(node1, 5);
        System.out.println();
    }
}
