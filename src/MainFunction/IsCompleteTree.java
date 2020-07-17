package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: 兴希
 * Date: 2020/5/20
 * Time: 23:16
 * Description: 给定一个二叉树，确定它是否是一个完全二叉树。
 *              百度百科中对完全二叉树的定义如下：
 *              若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 *              第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 
 *              个节点。）
 */
public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            list.add(size);
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left==null&&node.right!=null){
                    return false;
                }
                if (node.left==null||node.right==null){
                    flag = false;
                }
                if (node.left!=null){
                    if (!flag){
                        return false;
                    }
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    if (!flag){
                        return false;
                    }
                    queue.offer(node.right);
                }
            }

        }

        for (int i=1;i<list.size()-1;i++){
            if (list.get(i)!=list.get(i-1)*2){
                return false;
            }
        }
        return true;
    }
}
