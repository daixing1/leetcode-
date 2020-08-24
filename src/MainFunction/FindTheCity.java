package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/7/23
 * Time: 10:22
 * Description: 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti]
 *              代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 *              返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。
 *              如果有多个这样的城市，则返回编号最大的城市。
 *              注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 */
public class FindTheCity {
    Map<Integer, List<int[]>> map;
//    int threshold;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        map = new HashMap<>();
//        threshold = distanceThreshold;
        for (int i=0;i<edges.length;i++){
            if (map.containsKey(edges[i][0])){
                map.get(edges[i][0]).add(edges[i]);
            }else {
                List<int[]> tolist = new ArrayList<>();
                tolist.add(edges[i]);
                map.put(edges[i][0],tolist);
            }
            if (map.containsKey(edges[i][1])){
                map.get(edges[i][1]).add(edges[i]);
            }else {
                List<int[]> tolist = new ArrayList<>();
                tolist.add(edges[i]);
                map.put(edges[i][1],tolist);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            int count = getCount(i,distanceThreshold,set);
            list.add(count);
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i=0;i<n;i++){
            if (min>=list.get(i)){
                min = list.get(i);
                index = i;
            }
        }
        return index;
    }

    private int getCount(int i,int threshold, Set<Integer> except){
        int count = 0;
        List<int[]> list1 = map.get(i);
        if (list1!=null){
            for (int j=0;j<list1.size();j++){
                if (except.contains(list1.get(j)[0])&&except.contains(list1.get(j)[1])){
                    continue;
                }
                if (list1.get(j)[2]==threshold){
                    count++;
                    except.add(list1.get(j)[0]);
                    except.add(list1.get(j)[1]);
                }else if (list1.get(j)[2]<threshold){
                    except.add(list1.get(j)[0]);
                    except.add(list1.get(j)[1]);
                    count += getCount(list1.get(j)[0]==i?list1.get(j)[1]:list1.get(j)[0],threshold-list1.get(j)[2],except)+1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindTheCity findTheCity = new FindTheCity();
        int theCity = findTheCity.findTheCity(6, new int[][]{
                {0,3,5},{2,3,7},{0,5,2},{0,2,5},{1,2,6},{1,4,7},{3,4,4},{2,5,5},{1,5,8}}, 8279);
        System.out.println(theCity);
    }
}
