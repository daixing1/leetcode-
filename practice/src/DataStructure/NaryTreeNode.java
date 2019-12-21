package DataStructure;

import java.util.List;

/**
 * User: 兴希
 * Date: 2019/12/13
 * Time: 16:48
 * Description: N叉树节点
 */
public class NaryTreeNode {
    public int val;
    public List<NaryTreeNode> children;

    public NaryTreeNode() {}

    public NaryTreeNode(int _val) {
        val = _val;
    }

    public NaryTreeNode(int _val, List<NaryTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
