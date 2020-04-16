package MainFunction;

import DataStructure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/3/7
 * Time: 23:54
 * Description: 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的
 *              ，定义其为对称的。
 */
public class IsSymmetrical {
    public static boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }
        if(pRoot.left==null&&pRoot.right==null){
            return true;
        }
        if((pRoot.left==null&&pRoot.right!=null)||(pRoot.left!=null&&pRoot.right==null)||
                (pRoot.left!=null&&pRoot.right!=null&&pRoot.left.val!=pRoot.right.val)){
            return false;
        }
        return isSymmetrical(pRoot.left)&&isSymmetrical(pRoot.right);
    }

    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] ints = {1, 2, 3};
        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());

        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        boolean symmetrical = isSymmetrical(node1);
        System.out.println();
    }
}
