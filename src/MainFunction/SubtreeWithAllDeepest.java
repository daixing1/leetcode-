package MainFunction;

import DataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/8/7
 * Time: 22:09
 * Description: 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 *              如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 *              一个结点的子树是该结点加上它的所有后代的集合。
 *              返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 */
public class SubtreeWithAllDeepest {
    Map<TreeNode, Integer> depth;
    int max_depth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap();
        depth.put(null, -1);
        dfs(root, null);
        max_depth = -1;
        for (Integer d: depth.values())
            max_depth = Math.max(max_depth, d);

        return answer(root);
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == max_depth)
            return node;
        TreeNode L = answer(node.left),
                R = answer(node.right);
        if (L != null && R != null) return node;
        if (L != null) return L;
        if (R != null) return R;
        return null;
    }

    public static void main(String[] args) {
        SubtreeWithAllDeepest subtreeWithAllDeepest = new SubtreeWithAllDeepest();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(1);
        TreeNode node11 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        node8.left = node10;
        node8.right = node11;
        TreeNode node = subtreeWithAllDeepest.subtreeWithAllDeepest(node1);
        System.out.println();
    }
}
