package MainFunction;

import DataStructure.ListNode;
import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/5/2
 * Time: 11:52
 * Description: 给出一棵二叉树，其上每个结点的值都是0或1 。每一条从根到叶的路径都代表一个从最高有效位开始的
 *              二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *              对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *              以 10^9 + 7 为模，返回这些数字之和。
 */
public class SumRootToLeaf {
    static int sum = 0;
    public static int sumRootToLeaf(TreeNode root) {
        int digita = 0;
        sumLeft(root,0);
        return sum;
    }

    public static void sumLeft(TreeNode root,int digita){
        if (root!=null){
            digita<<=1;
            digita+=root.val;
            if (root.left==null&&root.right==null){
                sum += digita;
            }else {
                sumLeft(root.left,digita);
                sumLeft(root.right,digita);
            }
        }
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node4;
        node2.left = node3;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        int i = sumRootToLeaf(node6);
        System.out.println(i);
    }
}
