package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/24
 * Time: 9:38
 * Description: 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 *              对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，
 *              此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目
 */
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();
        for (int n:candies){
            if (n+extraCandies>=max){
                res.add(true);
            }else {
                res.add(false);
            }
        }
        return res;
    }
}
