package MainFunction;

import DataStructure.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/8/15
 * Time: 21:32
 * Description: 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class Postorder {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<Node> children = root.children;
        if (children!=null){
            for (Node node:children){
                postorder(node);
            }
        }
        list.add(root.val);
        return list;
    }
}
