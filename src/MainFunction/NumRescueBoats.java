package MainFunction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/7/5
 * Time: 10:22
 * Description: 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *              每艘船最多可同时载 两人 ，但条件是这些人的重量之和最多为 limit。
 *              返回载到每一个人所需的最小船数。(保证每个人都能被船载)
 */
public class NumRescueBoats {
    public static int numRescueBoats(int[] people, int limit) {
        List<Integer> weights = Arrays.stream(people).boxed().sorted((o1, o2) -> o2-o1).collect(Collectors.toList());
        int count = 0;
        int i=0,j=people.length-1;
        int sum = 0;
        while (i<=j){
            sum=weights.get(i);
            i++;
            if (i<=j+1&&sum<limit){
                sum+=weights.get(j);
                if (sum<=limit){
                    j--;
                }
            }
            count++;
            sum=0;
        }
        if (sum!=0){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = numRescueBoats(new int[]{3,2,2,2,3}, 6);
        System.out.println(i);
    }
}
