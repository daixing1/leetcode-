package DataStructure;

import java.util.*;

/**
 * User: 兴希
 * Date: 2019/12/12
 * Time: 19:17
 * Description: 二叉树节点
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static void main(String[] args) {
        List<Integer> tweetIds = new ArrayList<>();
        tweetIds.addAll(Arrays.asList(1,6,2,4,85,3));
        Collections.sort(tweetIds, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2){
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        System.out.println(tweetIds);
    }

}
