package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/10
 * Time: 9:13
 * Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *              百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *              满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {
    Map<Integer,TreeNode> map = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        List<TreeNode> list = new ArrayList<>();
        while (true){
            TreeNode node = map.get(p.val);
            list.add(node);
            if (node==null){
                break;
            }
            p = node;
        }
        while (true){
            TreeNode node = map.get(q.val);
            if (list.contains(node)){
                return node;
            }
            if (node==null){
                break;
            }
            q = node;
        }
        return null;
    }

    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        if (root.left!=null){
            map.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right!=null){
            map.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
