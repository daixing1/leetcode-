package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/25
 * Time: 10:43
 * Description: 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 *              如果数组中不存在满足题意的整数，则返回 0 。
 */
public class SumFourDivisors {
    public static int sumFourDivisors(int[] nums) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (Math.pow((int)Math.sqrt(nums[i]),2)==nums[i]){
                continue;
            }
            for (int j=1;j<Math.sqrt(nums[i]);j++){
                if (nums[i]%j==0){
                    list.add(j);
                    list.add(nums[i]/j);
                }
            }
            if (list.size()==4){
                res+=list.stream().mapToInt(o->o).sum();
            }
            list.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        int i = sumFourDivisors(new int[]{1,2,3,4,5});
        System.out.println(i);
    }
}
