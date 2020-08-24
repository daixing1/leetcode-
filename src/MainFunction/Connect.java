package MainFunction;

import DataStructure.TreeNextNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: 兴希
 * Date: 2020/7/24
 * Time: 17:04
 * Description: 给定一个二叉树
 *                  struct Node {
 *                      int val;
 *                      Node *left;
 *                      Node *right;
 *                      Node *next;
 *                  }
 *              填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
 *              则将 next 指针设置为 NULL。
 *              初始状态下，所有 next 指针都被设置为 NULL。
 *              进阶：
 *                  你只能使用常量级额外空间。
 *                  使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Connect {
    public TreeNextNode connect(TreeNextNode root) {
        if (root==null){
            return root;
        }
        TreeNextNode res = root;
        Queue<TreeNextNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNextNode head = queue.poll();
            if (head.left!=null){
                queue.offer(head.left);
            }
            if (head.right!=null){
                queue.offer(head.right);
            }
            for (int i=0;i<size-1;i++){
                TreeNextNode poll = queue.poll();
                head.next = poll;
                head = poll;
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }


}
