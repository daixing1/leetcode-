package MainFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/1
 * Time: 10:14
 * Description: 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，
 *              找到它的主要元素。若没有，返回-1。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length<2){
            return -1;
        }
//        List<Integer> list = new ArrayList<>();
////        list.add(nums[0]);
//        for (int i=1;i<nums.length;i++){
//            if (list.size()==0){
//                list.add(nums[i]);
//                continue;
//            }
//            if (list.get(list.size()-1)==nums[i]){
//                list.add(nums[i]);
//            }else {
//                list.remove(list.size()-1);
//            }
//        }
//        return list.get(0);
        Map<Integer,Integer> map = new HashMap<>();
        for (int n:nums){
            if (map.containsKey(n)){
                map.put(n,map.get(n)+1);
                if (map.get(n)>nums.length/2){
                    return n;
                }
            }else {
                map.put(n,1);
            }
        }
        return -1;
    }

    public static int majorityElement1(int[] nums) {
        //摩尔投票法
        int len = nums.length;
        if(len<1){
            return -1;
        }
        if(len==1){
            return nums[0];
        }
        int num = nums[0];
        int cnt = 1;
        for(int i=1;i<len;i++){
            if(cnt==0){
                num = nums[i];
                cnt=1;
            }else if(num==nums[i]){
                cnt++;
            }else if(num!=nums[i]){
                cnt--;
            }
        }
        if(cnt!=0){
            return num;
        }
        return -1;
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if (nums.length<3){
            return nums[0];
        }
        int count = 1;
        int tmp = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=tmp){
                count--;
                if (count==0){
                    count = 1;
                    tmp = nums[i];
                }
            }else {
                count++;
            }
        }
        return tmp;
    }


    public static void main(String[] args) {
        int i = majorityElement1(new int[]{1, 1, 1, 2, 2, 2, 3, 3});
        System.out.println(i);

//        LowestCommonAncestor l = new LowestCommonAncestor();
//        l.lowestCommonAncestor()
    }
}
