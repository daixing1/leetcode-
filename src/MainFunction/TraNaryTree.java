package MainFunction;

import DataStructure.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2019/12/13
 * Time: 16:49
 * Description: 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class TraNaryTree {
    public List<List<Integer>> levelOrder(NaryTreeNode root) {
        List<List<Integer>> integerList = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        if (root==null){
            integerList.add(integers);
            return integerList;
        }else {
            integers.add(root.val);
            integerList.add(integers);
            traverse(root.children,integerList);
        }
        return integerList;
    }

    public List<List<Integer>> traverse(List<NaryTreeNode> childrens, List<List<Integer>> integerList){
        List<Integer> integers = new ArrayList<>();
        for (NaryTreeNode naryTree:childrens){
            if (naryTree!=null){
                integers.add(naryTree.val);
            }
        }
        if (integers.size()>0){
            integerList.add(integers);
        }
        List<NaryTreeNode> childs = new ArrayList<>();
        for (NaryTreeNode naryTree:childrens){
            for (NaryTreeNode naryTree1:naryTree.children){
                childs.add(naryTree1);
            }
        }
        traverse(childs,integerList);
        return integerList;
    }
}
