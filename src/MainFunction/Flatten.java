package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2019/12/25
 * Time: 14:51
 * Description: 给定一个二叉树，原地将它展开为链表。
 */
public class Flatten {
    public static void flatten(TreeNode root) {
        if (root!=null){
            flatten(root.left);
            flatten(root.right);
            TreeNode node = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right!=null){
                root = root.right;
            }
            root.right = node;
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        flatten(node1);
        System.out.println("dsfs");
    }
}
