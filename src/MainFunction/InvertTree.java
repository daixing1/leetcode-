package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 9:29
 * Description: 翻转一棵二叉树。
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        invertTree(root.right);
        invertTree(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
