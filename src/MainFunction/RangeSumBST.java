package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/6
 * Time: 22:27
 * Description: 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *              二叉搜索树保证具有唯一的值。
 */
public class RangeSumBST {
    int res = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root==null){
            return 0;
        }
        bst(root,L,R);
        return res;
    }

    public void bst(TreeNode root, int L, int R){
        if (root==null){
            return;
        }
        if (root.val>L&&root.val<R){
            res+=root.val;
            bst(root.left,L,R);
            bst(root.right,L,R);
        }
        if (root.val>=R){
            if (root.val==R){
                res+=root.val;
            }
            bst(root.left,L,R);

        }
        if (root.val<=L){
            if (root.val==L){
                res+=root.val;
            }
            bst(root.right,L,R);
        }
    }

    public static void main(String[] args) {
        RangeSumBST rangeSumBST = new RangeSumBST();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(18);
//        TreeNode node7 = new TreeNode(1);
//        TreeNode node8 = new TreeNode(1);
//        TreeNode node9 = new TreeNode(1);
//        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        int i = rangeSumBST.rangeSumBST(node1, 7, 15);
        System.out.println(i);
    }
}
