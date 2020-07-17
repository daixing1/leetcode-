package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/3
 * Time: 10:04
 * Description: 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 *              这条路径上所有节点值相加等于目标和。
 *              说明: 叶子节点是指没有子节点的节点。
 */
public class HasPathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        if (sum==root.val&&root.right==null&&root.left==null){
            return true;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(13);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node3.right = node5;
        node1.right = node6;
        node6.left = node7;
        node6.right = node8;
        node8.right = node9;
        boolean b = hasPathSum(node1, 22);
        System.out.println(b);
    }
}
