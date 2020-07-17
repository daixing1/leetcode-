package MainFunction;

import DataStructure.TreeNode;

import java.util.PriorityQueue;

/**
 * User: 兴希
 * Date: 2020/6/16
 * Time: 10:49
 * Description: 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *              调用 next() 将返回二叉搜索树中的下一个最小的数。
 */
public class BSTIterator {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public BSTIterator(TreeNode root) {
        addQueue(root);
    }

    public void addQueue(TreeNode root){
        if (root!=null){
            queue.add(root.val);
            if (root.left!=null){
                addQueue(root.left);
            }
            if (root.right!=null){
                addQueue(root.right);
            }
        }
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
