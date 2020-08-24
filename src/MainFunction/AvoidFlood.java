package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/7/19
 * Time: 20:44
 * Description: 你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨的时候，如果第 n 个湖泊是空的，
 *              那么它就会装满水，否则这个湖泊会发生洪水。你的目标是避免任意一个湖泊发生洪水。
 *              给你一个整数数组 rains ，其中：
 *              rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
 *              rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
 *              请返回一个数组 ans ，满足：
 *              ans.length == rains.length
 *              如果 rains[i] > 0 ，那么ans[i] == -1 。
 *              如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
 *              如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
 *              请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，
 *              那么将无事发生。
 */
public class AvoidFlood {
    public int[] avoidFlood(int[] rains) {
        List<Integer> sun = new ArrayList<>();
        int[] res = new int[rains.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<rains.length;i++){
            if (rains[i]!=0){
                if (sun.size()==0&&set.contains(rains[i])){
                    return new int[0];
                }
                if (sun.size()!=0&&set.contains(rains[i])){
                    for (int j=0;j<sun.size();j++){
                        if (map.get(sun.get(j)).contains(rains[i])){
                            res[sun.get(j)] = rains[i];
                            sun.remove(j);
                            break;
                        }
                    }
                }
                set.add(rains[i]);
                res[i] = -1;
            }
            if (rains[i]==0){
                if (set.size()!=0){
                    sun.add(i);
                    map.put(i,new HashSet<>(set));
                    if (sun.size()>=set.size()){
                        int j=0;
                        Iterator<Integer> iterator = set.iterator();
                        while (iterator.hasNext()){
                            res[sun.get(j++)] = iterator.next();
                        }
                        set.clear();
                        sun.clear();
                    }
                }else {
                    sun.clear();
                    res[i]=1;
                }
            }
            if (i!=0&&rains[i]==rains[i-1]&&rains[i]!=0){
                return new int[0];
            }
        }
//        for (int i=0;i<res.length;i++){
//            if (res[i]==0){
//                res[i] = 1;
//            }
//        }
        return res;
    }

    public static void main(String[] args) {
        AvoidFlood avoidFlood = new AvoidFlood();
//        -1,-1,-1,0,-1,0,80971,-1,93949,24526,1,-1,55547,-1,-1,-1,-1,80482,77698,54795,74942,-1,77698,1,-1,54410,1,-1,23938,1,1,1,1,1,-1,75018,1,-1,47564,-1,24526,1,1,-1,48639,-1,-1,-1,-1,-1,6992,-1,-1,68554,39045,75357,-1,-1,-1,-1,82220,-1,40783,-1,0,0,-1,0,0,-1,0,-1,-1,-1,0,-1,-1,87360,-1,-1,0,-1,-1,0,0,-1]
        int[] ints = avoidFlood.avoidFlood(
                new int[]{
                        24526,23938,93949,0,61370,0,0,80971,0,0,0,55547,0,80482,74942,
                        77698,54795,0,0,0,0,77698,0,0,54410,0,0,23938,0,0,0,0,0,0,75018,
                        0,0,47564,0,24526,0,0,0,48639,0,68554,39045,75357,48639,6992,0,
                        47564,54410,0,0,0,74942,6992,40783,82220,0,75018,0,61370,0,0,
                        68554,0,0,82220,0,40783,55547,80971,0,93949,87360,0,87360,39045,
                        0,80482,75357,0,0,54795}
//                new int[]{1,3,0,2,0,1,2}
//                new int[]{3,5,4,0,1,0,1,5,2,8,9}
                );
        System.out.println();
    }
}











