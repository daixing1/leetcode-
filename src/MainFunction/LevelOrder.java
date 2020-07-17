package MainFunction;

import DataStructure.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: 兴希
 * Date: 2020/5/6
 * Time: 10:53
 * Description: 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class LevelOrder {
    public static int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
//        TreeNode node6 = new TreeNode(0);
//        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        node4.left = node6;
//        node4.right = node7;
        int[] ints = levelOrder(node1);
        System.out.println();
    }
}
