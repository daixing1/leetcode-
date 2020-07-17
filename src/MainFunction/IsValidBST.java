package MainFunction;

import DataStructure.TreeNode;

import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/5
 * Time: 9:43
 * Description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *              假设一个二叉搜索树具有如下特征：
 *                  节点的左子树只包含小于当前节点的数。
 *                  节点的右子树只包含大于当前节点的数。
 *                  所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public static boolean helper(TreeNode root, Integer lower, Integer upper){
        if (root==null){
            return true;
        }
        if (lower!=null&&root.val>=lower){
            return false;
        }
        if (upper!=null&&root.val<=upper){
            return false;
        }
        return helper(root.left,root.val,upper)&&helper(root.right,lower,root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        boolean validBST = isValidBST(node1);
        System.out.println(validBST);
    }
}
