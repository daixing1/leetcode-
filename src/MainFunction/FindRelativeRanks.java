package MainFunction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: 兴希
 * Date: 2020/6/7
 * Time: 11:44
 * Description: 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予
 *              “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *              (注：分数越高的选手，排名越靠前。)
 */
public class FindRelativeRanks {
    public static String[] findRelativeRanks(int[] nums) {
        int[][] indexNum = new int[nums.length][2];
        for (int i=0;i<nums.length;i++){
            indexNum[i][0] = nums[i];
            indexNum[i][1] = i;
        }
        Arrays.sort(indexNum,(o1, o2) -> o2[0]-o1[0]);
        String[] res = new String[nums.length];
        for (int i=0;i<res.length;i++){
            if (i==0){
                res[indexNum[i][1]] = "Gold Medal";
            }
            if (i==1){
                res[indexNum[i][1]] = "Silver Medal";
            }
            if (i==2){
                res[indexNum[i][1]] = "Bronze Medal";
            }
            if (i>2){
                res[indexNum[i][1]] = String.valueOf(i+1);
            }
        }
        return res;
    }

    public static String[] findRelativeRanks1(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>((o1,o2)->o2-o1);
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        String[] res = new String[nums.length];
        for (int i=0;i<res.length;i++){
            if (i==0){
                res[((TreeMap<Integer, Integer>) map).firstEntry().getValue()] = "Gold Medal";
                map.remove(((TreeMap<Integer, Integer>) map).firstKey());
            }
            if (i==1){
                res[((TreeMap<Integer, Integer>) map).firstEntry().getValue()] = "Silver Medal";
                map.remove(((TreeMap<Integer, Integer>) map).firstKey());
            }
            if (i==2){
                res[((TreeMap<Integer, Integer>) map).firstEntry().getValue()] = "Bronze Medal";
                map.remove(((TreeMap<Integer, Integer>) map).firstKey());
            }
            if (i>2){
                res[((TreeMap<Integer, Integer>) map).firstEntry().getValue()] = String.valueOf(i+1);
                map.remove(((TreeMap<Integer, Integer>) map).firstKey());
            }
        }
        return res;
    }

    public String[] findRelativeRanks2(int[] nums) {
        String[] res = new String[nums.length];
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2-o1);
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int rank = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            rank++;
            if (rank==1){
                res[next.getValue()] = "Gold Medal";
            }else if (rank==2){
                res[next.getValue()] = "Silver Medal";
            }else if (rank==3){
                res[next.getValue()] = "Bronze Medal";
            }else {
                res[next.getValue()] = String.valueOf(rank);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] relativeRanks = findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        System.out.println(relativeRanks);
    }
}
