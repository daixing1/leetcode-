package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/6/29
 * Time: 9:59
 * Description: 计算给定二叉树的所有左叶子之和。
 */
public class SumOfLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null){
            return sumOfLeftLeaves(root.right);
        }
        if (root.left!=null&&root.left.left==null&&root.left.right==null){
            return root.left.val+sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-9);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(-6);
        TreeNode node8 = new TreeNode(-5);
        TreeNode node9 = new TreeNode(0);
        TreeNode node10 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        node6.left = node8;
        int i = sumOfLeftLeaves(node1);
        System.out.println(i);
    }
}
