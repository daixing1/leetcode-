package MainFunction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/6/26
 * Time: 8:07
 * Description: 给你两个长度相同的整数数组 target 和 arr 。
 *              每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 *              如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 */
public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length!=arr.length){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n:target){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for (int n:arr){
            if (!map.containsKey(n)){
                return false;
            }
            Integer count = map.get(n);
            if (count<1){
                return false;
            }
            map.put(n,map.get(n)-1);
        }
        for (int i=0;i<target.length;i++){
            if (target[i]==arr[i]){
                continue;
            }
            int j = i;
            while (target[i]!=arr[j]){
                j++;
            }
            reverse(arr,i,j);
        }
        for (int i=0;i<target.length;i++){
            if (target[i]!=arr[i]){
                return false;
            }
        }
        return true;
    }

    public void reverse(int[] arr,int start, int end){
        int tmp = 0;
        for (int i=start;i<(start+end+1)/2;i++){
            tmp = arr[i];
            arr[i] = arr[end+start-i];
            arr[end+start-i] = tmp;
        }
    }
}
