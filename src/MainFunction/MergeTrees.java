package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/9
 * Time: 10:47
 * Description: 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *              你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 *              否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        TreeNode res = new TreeNode(0);
        TreeNode root = new TreeNode(0);
        if (t1==null&&t2==null){
            return null;
        }
        if (t1!=null || t2!=null){
            root.val = (t1==null?0:t1.val)+(t2==null?0:t2.val);
            root.left = mergeTrees(t1==null?t1:t1.left,t2==null?t2:t2.left);
            root.right = mergeTrees(t1==null?t1:t1.right,t2==null?t2:t2.right);
        }
        return root;
    }

    public static void main(String[] args) {
        MergeTrees mergeTrees = new MergeTrees();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node5.left = node6;
        node5.right = node7;
        node6.right = node8;
        node7.right = node9;
        TreeNode node = mergeTrees.mergeTrees(node1, node5);
        System.out.println();
    }
}
