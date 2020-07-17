package MainFunction;

import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/24
 * Time: 10:00
 * Description: 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *              有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 *              每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，
 *              但 B 不能向 A 传信息）。
 *              每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 *              给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
 *              返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 */
public class NumWays1 {
//    class Node{
//        int val;
//        List<Node> nexts;
//        public Node(int val){
//            this.val = val;
//        }
//    }
    int count = 0;
    public int numWays(int n, int[][] relation, int k) {
        ways(n,relation,k);
        return count;
    }

    public void ways(int n, int[][] relation, int k){
        if (k==0){
            if (n==1){
                count++;
            }
            return;
        }
        for (int i=0;i<relation.length;i++){
            if (relation[i][1]==n-1){
                ways(relation[i][0]+1,relation,k-1);
            }
        }
    }

    public static void main(String[] args) {
        NumWays1 numWays1 = new NumWays1();
        int i = numWays1.numWays(3, new int[][]{{0,2},{0,1},{1,2},{2,1},{2,0},{1,0}}, 1);
        System.out.println(i);
    }
}
