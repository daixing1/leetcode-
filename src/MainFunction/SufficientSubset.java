package MainFunction;

import DataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/28
 * Time: 10:16
 * Description: 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。
 *              （所谓一个叶子节点，就是一个没有子节点的节点）
 *              假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，
 *              则该节点被称之为「不足节点」，需要被删除。
 *              请你删除所有不足节点，并返回生成的二叉树的根
 */
public class SufficientSubset {
    Map<TreeNode,TreeNode> map = new HashMap<>();
//    Map<TreeNode,Integer> sumMap = new HashMap<>();
    int sum = 0;
    int limit;
    TreeNode root;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        this.root = root;
        if (root==null){
            return null;
        }
        getParMap(root);
        getSum(root);
        return root;
    }

    public void getParMap(TreeNode root){
        while (root!=null){
            TreeNode left = root.left;
            if (left!=null){
                map.put(left,root);
            }
            getParMap(root.left);
            TreeNode right = root.right;
            if (right!=null){
                map.put(right,root);
            }
            getParMap(root.right);
        }
    }

    public void getSum(TreeNode treeNode){
        while (treeNode!=null){
            getSum(treeNode.left);
            getSum(treeNode.right);
        }
        int parSum = getParSum(treeNode);
        if (parSum<limit){
            TreeNode node = map.get(treeNode);
            if (node.left==treeNode){
                node.left = null;
            }else {
                node.right = null;
            }
        }else {
            return;
        }
    }

    public int getParSum(TreeNode treeNode){
        while (map.containsKey(treeNode)){
            sum+=map.get(treeNode).val;
            treeNode = map.get(treeNode);
        }
        return sum;
    }
}
