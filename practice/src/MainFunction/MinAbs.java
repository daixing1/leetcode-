package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2019/12/12
 * Time: 17:58
 * Description: No Description
 */
//给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
public class MinAbs {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(543);
        TreeNode l = new TreeNode(384);
        TreeNode r = new TreeNode(652);
        TreeNode lr = new TreeNode(445);
        TreeNode rr = new TreeNode(699);
        root.left = l;
        root.right = r;
        l.right = lr;
        r.right = rr;
        getMinimumDifference(root);
    }

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = getArray(root,list);
        for(int i=0;i<list.size();i++){
            int maxnum = list.get(i);
            for(int j = i;j<list.size();j++){
                if(maxnum < list.get(j)){
                    maxnum = list.get(j);
                    list.set(j,list.get(i));
                    list.set(i,maxnum);
                }
            }
        }
        int min = Math.abs(list.get(0) - list.get(1));
        for(int i=0;i<list.size()-1;i++){
            int def = Math.abs(list.get(i) - list.get(i+1));
            if(min > def){
                min = def;
            }
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
