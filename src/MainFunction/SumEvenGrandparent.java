package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/8
 * Time: 11:46
 * Description: 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *              该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 *              如果不存在祖父节点值为偶数的节点，那么返回 0 。
 */
public class SumEvenGrandparent {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if (root!=null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (root.val%2==0){
                if (left!=null){
                    if (left.left!=null){
                        sum+=left.left.val;
                    }
                    if (left.right!=null){
                        sum+=left.right.val;
                    }
                }
                if (right!=null){
                    if (right.left!=null){
                        sum+=right.left.val;
                    }
                    if (right.right!=null){
                        sum+=right.right.val;
                    }
                }

            }
            if (left!=null&&(left.left!=null||left.right!=null)){
                sumEvenGrandparent(left);
            }
            if (right!=null&&(right.left!=null||right.right!=null)){
                sumEvenGrandparent(right);
            }
        }
        return sum;
    }

    private int ans = 0;

    public int sumEvenGrandparent1(TreeNode root) {
        dfs(null, null, root);
        return ans;
    }

    private void dfs(TreeNode grandparent, TreeNode parent, TreeNode  node) {
        if(node == null) {
            return ;
        }
        if(grandparent != null && (grandparent.val & 1) == 0) {
            ans += node.val;
        }
        dfs(parent, node, node.left);
        dfs(parent, node, node.right);
    }

    public static void main(String[] args) {
        SumEvenGrandparent sumEvenGrandparent = new SumEvenGrandparent();
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(9);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(4);
        TreeNode node11 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node5.left = node9;
        node5.right = node10;
        node7.right = node11;
        int i = sumEvenGrandparent.sumEvenGrandparent1(node1);
        System.out.println(i);
    }
}
