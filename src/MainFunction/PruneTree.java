package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/8/2
 * Time: 14:30
 * Description: 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *              返回移除了所有不包含 1 的子树的原二叉树。
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root==null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left!=null&&root.left.left==null&&root.left.right==null&&root.left.val==0){
            root.left = null;
        }
        if (root.right!=null&&root.right.left==null&&root.right.right==null&&root.right.val==0){
            root.right = null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(0);
        TreeNode treeNode9 = new TreeNode(1);
        TreeNode treeNode10 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        PruneTree pruneTree = new PruneTree();
        TreeNode node = pruneTree.pruneTree(treeNode1);
        System.out.println(node);

    }
}
