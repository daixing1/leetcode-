package MainFunction;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: 兴希
 * Date: 2020/6/6
 * Time: 10:56
 * Description: 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 *              添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 
 *              v 的左子树和右子树。
 *              将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 *              如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 */
public class AddOneRow {
    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d==1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (level==d){
                    poll.left = new TreeNode(v);
                    poll.right = new TreeNode(v);
                }
                if (left!=null){
                    if (level==d){
                        poll.left.left = left;
                    }
                    queue.offer(poll.left);
                }
                if (right!=null){
                    if (level==d){
                        poll.right.right = right;
                    }
                    queue.offer(poll.right);
                }
            }
            if (d==level){
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        addOneRow(node1,1,4);
    }
}
