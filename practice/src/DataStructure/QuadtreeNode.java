package DataStructure;

/**
 * User: 兴希
 * Date: 2019/12/13
 * Time: 16:07
 * Description: 四叉树节点
 */
public class QuadtreeNode {

    public boolean val;
    public boolean isLeaf;
    public QuadtreeNode topLeft;
    public QuadtreeNode topRight;
    public QuadtreeNode bottomLeft;
    public QuadtreeNode bottomRight;

    public QuadtreeNode() {}

    public QuadtreeNode(boolean _val,boolean _isLeaf,QuadtreeNode _topLeft,
                        QuadtreeNode _topRight,QuadtreeNode _bottomLeft,
                        QuadtreeNode _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
