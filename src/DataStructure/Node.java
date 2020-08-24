package DataStructure;

import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/22
 * Time: 21:14
 * Description: No Description
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
