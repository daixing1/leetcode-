package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/18
 * Time: 10:54
 * Description: 给定一个二叉树，它的每个结点都存放着一个整数值。
 *              找出路径和等于给定数值的路径总数。
 *              路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *              二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class PathSum {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root==null){
            return 0;
        }
        count(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }
    private void count(TreeNode root, int sum){
        if (root==null){
            return;
        }
        if (sum==root.val){
            count++;
        }
        count(root.left,sum-root.val);
        count(root.right,sum-root.val);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        int i = pathSum.pathSum(node1,8);
        System.out.println(i);
    }
}
