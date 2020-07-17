package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/12
 * Time: 8:48
 * Description: 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *              说明：解集不能包含重复的子集。
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        for (int i=1;i<=nums.length;i++){
            getAllSubSet(nums,i,new ArrayList<>(),flag);
        }
        return res;
    }

    public void getAllSubSet(int[] nums,int count, List<Integer> list,boolean[] flag){
        if (list.size()==count){
            List<Integer> tmp = new ArrayList<>();
            tmp = list;
            res.add(tmp);
            return;
        }
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<i+count;j++){
                if (!flag[j]){
                    list.add(nums[j]);
                    flag[j] = true;
                    getAllSubSet(nums,count,list,flag);
                    flag[j] = false;
                }

            }
        }
    }
}
