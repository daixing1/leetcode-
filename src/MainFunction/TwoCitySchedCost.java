package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/30
 * Time: 12:00
 * Description: 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *              返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 */
public class TwoCitySchedCost {
    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,((o1, o2) -> Math.abs(o2[0]-o2[1])-Math.abs(o1[0]-o1[1])));
        int count1 = 0;
        int count2 = 0;
        int res = 0;
        for (int[] cost:costs){
            if ((cost[0]>cost[1]&&count2<costs.length/2)||count1==costs.length/2){
                count2++;
                res+=cost[1];
            }else {
                count1++;
                res+=cost[0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = twoCitySchedCost(new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}});
        System.out.println(res);

    }
}
