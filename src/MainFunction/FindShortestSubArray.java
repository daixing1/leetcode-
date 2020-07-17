package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/6/24
 * Time: 11:16
 * Description: 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *              你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class FindShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        List<Integer> nlist=new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max = Math.max(max,map.get(nums[i]));
        }
        if (max==1){
            return 1;
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue()==max){
                nlist.add(next.getKey());
            }
        }
        int[][] pos = new int[nlist.size()][2];
        for (int i=0;i<nlist.size();i++){
            for (int j=0;j<nums.length;j++){
                if (nums[j]==nlist.get(i)){
                    if (pos[i][0]!=0){
                        pos[i][1] = j;
                    }else {
                        if (nums[0]==nlist.get(i)){
                            pos[i][1] = j;
                        }else {
                            pos[i][0] = j;
                        }
                    }
                }
            }
        }
        Arrays.sort(pos, Comparator.comparingInt(o -> (o[1] - o[0])));
        return pos[0][1]-pos[0][0]+1;
    }

    public static void main(String[] args) {
        int shortestSubArray = findShortestSubArray(new int[]{1, 2});
        System.out.println(shortestSubArray);
    }
}
