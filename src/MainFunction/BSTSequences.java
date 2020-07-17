package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/27
 * Time: 9:12
 * Description: No Description
 */
public class BSTSequences {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> BSTSequences(TreeNode root) {
        BST(root,new ArrayList<>());
        return res;
    }

    public void BST(TreeNode root,List<Integer> list){
        if (root!=null){
            list.add(root.val);
            BST(root.left,list);
        }
    }
}
