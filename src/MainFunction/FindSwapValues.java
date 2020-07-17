package MainFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/4/29
 * Time: 11:28
 * Description: 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *              返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
 *              若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 */
public class FindSwapValues {
    public static int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0,sum2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int n:array1){
            sum1+=n;
        }
        for (int n:array2){
            sum2+=n;
            set.add(n);
        }
        double diff = (sum1-sum2)/2.0;
        if ((sum1-sum2)%2!=0){
            return new int[0];
        }
        for (int n:array1){
//            for (int m:array2){
                if (set.contains((int) (n-diff))){
                    return new int[]{n, (int) (n-diff)};
                }
//            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] swapValues = findSwapValues(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});
        System.out.println(swapValues);
    }
}
