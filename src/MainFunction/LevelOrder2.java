package MainFunction;

import DataStructure.TreeNode;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/5/6
 * Time: 11:15
 * Description: 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class LevelOrder2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size();i>0;i--){
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
                tmp.add(poll.val);
            }
            res.add(tmp);
        }
        return res;
    }
}
