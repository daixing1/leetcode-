package MainFunction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/6/6
 * Time: 11:24
 * Description: 我们有一个非负整数数组 A。
 *              对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进
 *              行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 *              返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 */
public class SubarrayBitwiseORs {
    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>();
        if (A.length==1){
            return 1;
        }

        int tmp = 0;
        for (int i=0;i<A.length;i++){
            tmp = 0;
            for (int j=i;j<A.length;j++){
                tmp|=A[j];
                set.add(tmp);
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        int i = subarrayBitwiseORs(new int[]{39,19,30,56,79,50,19,70,30});
        System.out.println(i);
    }


}
