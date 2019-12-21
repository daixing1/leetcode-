package MainFunction;

import DataStructure.DoubleNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2019/12/13
 * Time: 17:39
 * Description: No Description
 */
public class FlatLinkList {
    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);
        DoubleNode node6 = new DoubleNode(6);
        DoubleNode node7 = new DoubleNode(7);
        DoubleNode node8 = new DoubleNode(8);
        DoubleNode node9 = new DoubleNode(9);
        DoubleNode node10 = new DoubleNode(10);
        DoubleNode node11 = new DoubleNode(11);
        DoubleNode node12 = new DoubleNode(12);
        node1.child = node2;
        node2.child = node3;
        node3.child = node4;
        node4.child = node5;
        node5.child = node6;
        node6.child = node7;
//        node3.child = node7;
        node7.child = node8;
        node8.child = node9;
        node9.child = node10;
        node10.child = node11;
        node11.child = node12;
        flatten(node1);

    }
    public static DoubleNode flatten(DoubleNode head) {
        if (head==null){
            return null;
        }
        DoubleNode node = new DoubleNode();
        node = head;
        List<DoubleNode> doubleNodes = new ArrayList<>();
        if (head.child == null){
            head.next.prev = head;
            head = head.next;
            getLinkList(head,doubleNodes);
        }else {
            if (head.next!=null){
                doubleNodes.add(head.next);
            }
            head.next = head.child;
            head.next.prev = head;
            head.child = null;
            getLinkList(head.next,doubleNodes);
        }
        return node;
    }
    public static void getLinkList(DoubleNode head,List<DoubleNode> next){
        List<DoubleNode> doubleNodes = new ArrayList<>();
        if (head.next!=null && head.child==null){
            head.next.prev = head;
            head = head.next;
            getLinkList(head,next);
        }else if (head.child!=null){
            DoubleNode node = head.next;
            head.next = head.child;
            head.next.prev = head;
            head.child = null;
            if (node!=null){
                next.add(node);
            }
            getLinkList(head.next,next);
        }else if (head.next==null && next.size()>0){
            head.next = next.get(next.size()-1);
            head.next.prev = head;
            next.remove(next.size()-1);
            getLinkList(head.next,next);
        }
    }
}
