package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/5/31
 * Time: 9:04
 * Description: 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        if (root==null||(root.left==null&&root.right==null)){
            return true;
        }
        if ((root.left==null&&root.right!=null)||(root.left!=null&&root.right==null)){
            return false;
        }
        return root.right.val==root.left.val&&isSameTree(root.left,root.right);
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2){
        if (t1==null&&t2==null){
            return true;
        }
        if ((t1!=null&&t2==null)||(t1==null&&t2!=null)){
            return false;
        }
        return t1.val==t2.val&&isSameTree(t1.left,t2.right)&&isSameTree(t1.right,t2.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        boolean symmetric = isSymmetric(node1);
        System.out.println(symmetric);
    }
}
