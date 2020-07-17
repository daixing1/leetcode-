package MainFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/5/22
 * Time: 8:10
 * Description: 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，
 *              你可以跳到 i + arr[i] 或者 i - arr[i]。
 *              请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 *              注意，不管是什么情况下，你都无法跳到数组之外。
 */
public class CanReach {
    public static boolean canReach(int[] arr, int start) {
        if (start>arr.length-1){
            return false;
        }
        if (arr[start]==0){
            return true;
        }
        boolean[] flag = new boolean[arr.length];
        Set<Integer> allIndex = new HashSet<>();
        List<Integer> index = new ArrayList<>();
        List<Integer> curIndex = new ArrayList<>();
        int len = 0;
        allIndex.add(start);
        index.add(start);
        while (true){
            len = allIndex.size();
            for (int n:index){
                if (arr[n]+n<=arr.length-1){
                    if (arr[arr[n]+n]==0){
                        return true;
                    }else {
                        curIndex.add(arr[n]+n);
                    }
                }
                if (n-arr[n]>=0){
                    if (arr[n-arr[n]]==0){
                        return true;
                    }else {
                        curIndex.add(n-arr[n]);
                    }
                }
            }
            allIndex.addAll(curIndex);
            index = new ArrayList<>(curIndex);
            curIndex.clear();
            if (len==allIndex.size()){
                return false;
            }
        }
    }

    public static void main(String[] args) {
        boolean b = canReach(new int[]{3,0,2,1,2}, 2);
        System.out.println(b);
    }
}
