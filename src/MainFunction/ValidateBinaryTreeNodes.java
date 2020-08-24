package MainFunction;

import DataStructure.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/7/26
 * Time: 21:45
 * Description: 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i]
 *              和 rightChild[i]。
 *              只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 *              如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 *              注意：节点没有值，本问题中仅仅使用节点编号。
 */
public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        for (int i=1;i<n;i++){
            set.add(i);
        }
        for (int m:leftChild){
            if (m!=-1&&set.contains(m)){
                set.remove(m);
            }
        }

        TreeNode root = new TreeNode(0);
        return false;
    }

    private boolean isValid(TreeNode node, int[] leftChild, int[] rightChild, int index){
        if (index>=leftChild.length){
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (leftChild[index]!=-1){
            node.left = new TreeNode(leftChild[index]);
        }
        if (rightChild[index]!=-1){
            node.right = new TreeNode(rightChild[index]);
        }
        if (node.left!=null){
            left = isValid(node,leftChild,rightChild,index+1);
        }
        if (node.right!=null){
            right = isValid(node,leftChild,rightChild,index+2);
        }
        return left&&right;
    }


}
