package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/12
 * Time: 9:58
 * Description: 给定一个非空二叉树，返回其最大路径和。
 *              本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class MaxPathSum {
    int tmp = 0;
    public int maxPathSum(TreeNode root) {
        int max = getMax(root);
        max = Math.max(tmp,max);
        if (max==0) {
            tmp = root.val;
            max = getMaxNodeValue(root);
        }
        return max;
    }

    private int getMax(TreeNode root){
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return root.val>0?root.val:0;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
//        if (root.val>0){
//            tmp = Math.max(left+right+root.val,tmp);
//            return left+right+root.val;
//        }else {
            tmp = Math.max(left+right+root.val,tmp);
            if (left+right+root.val>0){
                return left+right+root.val;
            }else {
                return 0;
            }
//        }
    }

    private int getMaxNodeValue(TreeNode root){
        if (root!=null&&root.left!=null){
            tmp = Math.max(root.val,getMaxNodeValue(root.left));
        }
        if (root!=null&&root.right!=null){
            tmp = Math.max(root.val,getMaxNodeValue(root.right));
        }
        if (root!=null&&root.right==null&&root.left==null){
            tmp = Math.max(root.val,tmp);
        }
        return tmp;
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
//        node3.left = node6;
//        node6.left = node7;
        int i = maxPathSum.maxPathSum(node1);
        System.out.println(i);
    }
}
