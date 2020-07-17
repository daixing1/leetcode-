package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/2
 * Time: 11:44
 * Description: 给你一个整数数组 arr，请你检查是否存在两个整数N和M，满足N是M的两倍（即，N = 2 * M）。
 *              更正式地，检查是否存在两个下标 i 和 j 满足：
 *                  i != j
 *                  0 <= i, j < arr.length
 *                  arr[i] == 2 * arr[j]
 */
public class CheckIfExist {
    public boolean checkIfExist(int[] arr) {
        Map<Double,Integer> map = new HashMap<>();
        for (int n:arr){
            if (map.containsKey(Double.valueOf(n*2))||map.containsKey(n/2.0)){
                return true;
            }else {
                map.put(Double.valueOf(n),n);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Double,Integer> map = new HashMap<>();
        map.put(Double.valueOf( 1),1);
        System.out.println(map.containsKey(1.0));
    }
}
