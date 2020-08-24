package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/10
 * Time: 9:13
 * Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *              百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *              满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {
    Map<Integer,TreeNode> map = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        List<TreeNode> list = new ArrayList<>();
        while (true){
            TreeNode node = map.get(p.val);
            list.add(node);
            if (node==null){
                break;
            }
            p = node;
        }
        while (true){
            TreeNode node = map.get(q.val);
            if (list.contains(node)){
                return node;
            }
            if (node==null){
                break;
            }
            q = node;
        }
        return null;
    }

    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        if (root.left!=null){
            map.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right!=null){
            map.put(root.right.val,root);
            dfs(root.right);
        }
    }

    //二叉搜索树
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val==p.val||root.val==q.val){
            return root;
        }
        List<TreeNode> plist = new ArrayList<>();
        List<TreeNode> qlist = new ArrayList<>();
        getAncestor(root,p,plist);
        getAncestor(root,q,qlist);
        TreeNode res = plist.get(0);
        TreeNode cur = plist.get(0);

        for (int i=1;i<plist.size();i++){
            cur = plist.get(i);
            if (qlist.contains(cur)){
                res = cur;
            }else {
                return res;
            }
        }
        return res;

    }
    public void getAncestor(TreeNode root, TreeNode p, List<TreeNode> list){
        list.add(root);
        if (root.val<p.val){
            getAncestor(root.right,p,list);
        }else if (root.val>p.val){
            getAncestor(root.left,p,list);
        }else {
            return;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
//        TreeNode node10 = new TreeNode(1);
//        TreeNode node11 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        TreeNode node = lowestCommonAncestor.lowestCommonAncestor1(node1,node2,node3);
        System.out.println(node);
    }
}
