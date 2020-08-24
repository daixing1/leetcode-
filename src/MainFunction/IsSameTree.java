package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/8/7
 * Time: 20:40
 * Description: 给定两个二叉树，编写一个函数来检验它们是否相同。
 *              如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null||q==null){
            if (p==null&&q==null){
                return true;
            }else {
                return false;
            }
        }
        if (q.val==p.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }
}
