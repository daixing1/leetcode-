package MainFunction;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User: 兴希
 * Date: 2020/3/3
 * Time: 21:51
 * Description: 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根
 *              结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        return  arrayLists;

    }

    public void find(TreeNode root, ArrayList<ArrayList<Integer>> arrayLists, Queue<TreeNode> queue, int target){
        while (root!=null){
            queue.add(root);
            target -= root.val;
            if (target==0){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (TreeNode e:queue){
                    arrayList.add(e.val);
                }
                arrayLists.add(arrayList);
            }else if (target>0){
//                if ()
            }
        }
    }
}
