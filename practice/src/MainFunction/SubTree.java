package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2019/12/15
 * Time: 16:32
 * Description: No Description
 */
public class SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&&t==null){
            return true;
        }else  if(s==null&&t!=null){
            return false;
        }else{
            return isSameTree(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
        }
    }

    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return true;
        }else if (s != null && t!=null &&s.val==t.val){
            return isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);
        }else {
            return false;
        }
    }
}
