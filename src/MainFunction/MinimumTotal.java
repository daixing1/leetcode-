package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/14
 * Time: 8:23
 * Description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *              相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null||triangle.size()==0){
            return 0;
        }
        List<List<Integer>> dp = new ArrayList<>();
        for (int i=0;i<triangle.size();i++){
            List<Integer> list = triangle.get(i);
            List<Integer> row = new ArrayList<>();
            for (int j=0;j<list.size();j++){
                if (i==0){
                    row.add(list.get(j));
                }else {
                    if (j==0){
                        row.add(dp.get(i-1).get(j)+list.get(j));
                    }else {
                        List<Integer> list1 = dp.get(i - 1);
                        int len = list1.size() - 1;
                        if (len>=j){
                            row.add(Math.min(list1.get(j),list1.get(j-1))+list.get(j));
                        }else if (len==j-1){
                            row.add(list1.get(j-1)+list.get(j));
                        }
                    }
                }
            }
            dp.add(row);
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list = dp.get(dp.size() - 1);
        if (list.size()==0){
            return 0;
        }
        for (int n:list){
            min = Math.min(min,n);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        int i = minimumTotal.minimumTotal(new ArrayList<>(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3))));
        System.out.println(i);
    }
}
