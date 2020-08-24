package DataStructure;

/**
 * User: 兴希
 * Date: 2020/7/24
 * Time: 17:04
 * Description: No Description
 */
public class TreeNextNode {
    public int val;
    public TreeNextNode left;
    public TreeNextNode right;
    public TreeNextNode next;

    public TreeNextNode() {}

    public TreeNextNode(int _val) {
        val = _val;
    }

    public TreeNextNode(int _val, TreeNextNode _left, TreeNextNode _right, TreeNextNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
