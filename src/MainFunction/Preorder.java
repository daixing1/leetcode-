package MainFunction;

import DataStructure.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/22
 * Time: 21:14
 * Description: 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class Preorder {
    List<Integer> list=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null){
            return list;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (children!=null){
            for (Node node:children){
                preorder(node);
            }
        }
        return list;
    }
}
