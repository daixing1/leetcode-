package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/13
 * Time: 9:34
 * Description: 给定一个二叉树，返回它的中序 遍历。
 */
public class Traversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null){
            return res;
        }
        res.add(root.val);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root==null){
            return res;
        }
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
