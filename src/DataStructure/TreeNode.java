package DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2019/12/12
 * Time: 19:17
 * Description: 二叉树节点
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
        List<Integer> list = new ArrayList<>(stack);
        System.out.println(list);
    }

}
