package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/6/5
 * Time: 10:03
 * Description: 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 *              最长路径的长度为树的深度。
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root!=null){
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }else {
            return 0;

        }
    }
}
