package MainFunction;

import DataStructure.TreeNode;

/**
 * User: 兴希
 * Date: 2020/7/3
 * Time: 9:35
 * Description: 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *              本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        TreeNode node = genarateBST(nums, 0, nums.length - 1);
        return node;
    }

    public TreeNode genarateBST(int[] nums, int start, int end){
        if (start==end){
            return new TreeNode(nums[start]);
        }
        int mid = (start+end)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        if (start<mid){
            treeNode.left = genarateBST(nums,start,mid-1);

        }
        if (end>mid){
            treeNode.right = genarateBST(nums,mid+1,end);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode node = sortedArrayToBST.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(node);
    }
}
