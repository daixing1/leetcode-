package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/18
 * Time: 9:34
 * Description: 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 *              这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        helper(root);
        return max-1;
    }

    private int helper(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = helper(root.left)+1;
        int right = helper(root.right)+1;
        max = Math.max(max,left+right-1);
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        int i = diameterOfBinaryTree.diameterOfBinaryTree(treeNode1);
        System.out.println(i);
    }
}
