package DataStructure;

/**
 * User: 兴希
 * Date: 2019/12/13
 * Time: 17:30
 * Description: 双向链表节点
 */
public class DoubleNode {
    public int val;
    public DoubleNode prev;
    public DoubleNode next;
    public DoubleNode child;
    public DoubleNode(int val){
        this.val = val;
    }
    public DoubleNode(){}
}
