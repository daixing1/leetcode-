package MainFunction;

import DataStructure.TreeNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * User: 兴希
 * Date: 2020/7/14
 * Time: 22:46
 * Description: 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *              （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 */
public class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        if (root==null){
            return -1;
        }
//        Set<Integer> setVal = new HashSet<>();
        Set<Integer> setDiff = new TreeSet<>((o1, o2) -> o2-o1);
//        getAllRoorVal(root,setVal);
        getAncestorDiff(root,root.left,setDiff);
        getAncestorDiff(root,root.right,setDiff);
        Iterator<Integer> iterator = setDiff.iterator();
        while (iterator.hasNext()){
            return iterator.next();
        }
        return -1;
    }

    private void getAncestorDiff(TreeNode parent, TreeNode son, Set<Integer> set){
        if (parent==null||son==null){
            return;
        }
        set.add(Math.abs(parent.val-son.val));
        if (son.left!=null||son.right!=null){
            getAncestorDiff(parent,son.left,set);
            getAncestorDiff(parent,son.right,set);
            getAncestorDiff(son,son.left,set);
            getAncestorDiff(son,son.right,set);
        }
    }

    private void getAllRoorVal(TreeNode root, Set<Integer> setVal){
        if (root==null){
            return;
        }
        setVal.add(root.val);
        getAllRoorVal(root.left,setVal);
        getAllRoorVal(root.right,setVal);
    }

//    public int maxAncestorDiff(TreeNode root) {
//        int diff = 0;
//        if (root == null) {
//            return -1;
//        }
//        Set<Integer> left = new TreeSet<>((o1, o2) -> o2-o1);
//        Set<Integer> right = new TreeSet<>((o1, o2) -> o2-o1);
//        getAllRoorVal(root.left,left);
//        getAllRoorVal(root.right,left);
//        Iterator<Integer> iterator = left.iterator();
//        while (iterator.hasNext()){
//            diff = Math.max(Math.abs())
//        }
//    }








    public static void main(String[] args) {
        MaxAncestorDiff maxAncestorDiff = new MaxAncestorDiff();
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;
        node6.left = node9;
        int i = maxAncestorDiff.maxAncestorDiff(node1);
        System.out.println(i);
    }
}
