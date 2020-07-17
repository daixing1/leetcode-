package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/6/26
 * Time: 10:02
 * Description: 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class GetMinimumDifference {
    public static int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = getArray(root,list);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        for (int i=1;i<collect.size();i++){
            min = Math.min(min,collect.get(i)-collect.get(i-1));
        }
        return min;
    }

    public static List<Integer> getArray(TreeNode root,List<Integer> list){
        if(root!= null ){
            list.add(root.val);
            getArray(root.left,list);
            getArray(root.right,list);
        }
        return list;
    }
}
