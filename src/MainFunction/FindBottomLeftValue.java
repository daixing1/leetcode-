package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: 兴希
 * Date: 2020/8/2
 * Time: 14:19
 * Description: 给定一个二叉树，在树的最后一行找到最左边的值。
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> lists = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
                list.add(poll.val);
            }
            lists.add(list);
        }
        return lists.get(lists.size()-1).get(0);
    }
}
