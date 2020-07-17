package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/4/22
 * Time: 10:20
 * Description: 一棵树从右向左看输出看到的节点值，即每层最右节点
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer,List<TreeNode>> map = new HashMap<>();
        traversal(0,root,map);
        for (int i=0;i<map.size();i++){
            if (map.containsKey(i)){
                res.add(map.get(i).get(0).val);
            }
        }
        return res;
    }

    public void traversal(Integer level,TreeNode node,Map<Integer,List<TreeNode>> map){
        if (node==null){
            return;
        }
        if (map.containsKey(level)){
            map.get(level).add(node);
        }else {
            map.put(level,new ArrayList<>());
            map.get(level).add(node);
        }
        traversal(level+1,node.right,map);
        traversal(level+1,node.left,map);
    }
}
