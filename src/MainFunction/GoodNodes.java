package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/19
 * Time: 20:39
 * Description: 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *              「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
public class GoodNodes {
    int count = 0;
    public int goodNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        traverse(root,root.val);
        return count;
    }
    private void traverse(TreeNode node, int num){
        if (node==null){
            return;
        }
        if (node.val>=num){
            count++;
        }
        traverse(node.left,Math.max(num,node.val));
        traverse(node.right, Math.max(num,node.val));
    }
}
