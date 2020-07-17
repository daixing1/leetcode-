package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/1
 * Time: 9:49
 * Description: 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        if (Math.abs(getDeep(root.left)-getDeep(root.right))>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public int getDeep(TreeNode node){
        if (node==null){
            return 0;
        }
        return Math.max(getDeep(node.left),getDeep(node.right))+1;
    }
}
