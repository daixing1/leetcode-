package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/5/6
 * Time: 11:36
 * Description: 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 *              返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        TreeNode node;
        while (root!=null){
            if (root.val>val){
                root = root.left;
            }else if ((root.val<val)){
                root = root.right;
            }else {
                node = root;
                break;
            }
        }
        return root;
    }
}
