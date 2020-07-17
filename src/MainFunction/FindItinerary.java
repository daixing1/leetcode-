package MainFunction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/6/27
 * Time: 8:55
 * Description: 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 *              对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，
 *              所以该行程必须从 JFK 出发。
 *              说明:
 *                  如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。
 *                  例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 *                  所有的机场都用三个大写字母表示（机场代码）。
 *                  假定所有机票至少存在一种合理的行程。
 */
public class FindItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        List<List<String>> collect = tickets.stream().sorted((o1, o2) -> {
            if (o1.get(0).equals(o2.get(0))){
                return o1.get(1).compareTo(o2.get(1));
            }else {
                return o1.get(0).compareTo(o2.get(0));
            }
        }).collect(Collectors.toList());
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> list:collect){
            if (map.containsKey(list.get(0))){
                map.get(list.get(0)).add(list.get(1));
            }else {
                List<String> stringList = new ArrayList<>();
                stringList.add(list.get(1));
                map.put(list.get(0),stringList);
            }
        }
        List<String> list = new LinkedList<>();
        String tmp = "JFK";
        list.add(tmp);
        while (!map.isEmpty()){
            List<String> stringList = map.get(tmp);
            if (stringList!=null&&!stringList.isEmpty()){
                String key = stringList.get(0);
                while (stringList.size()>1&&!map.containsKey(key)){
                    stringList.remove(key);
                    stringList.add(key);
                    key = stringList.get(0);
                }
                list.add(key);
                stringList.remove(0);
                if (stringList.size()==0){
                    map.remove(tmp);
                }
                tmp = key;
            }else {
                map.remove(tmp);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<String>> listList = new ArrayList<>();
//      [["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],
//          ["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
        listList.add(new ArrayList<>(Arrays.asList("EZE","AXA")));
        listList.add(new ArrayList<>(Arrays.asList("TIA","ANU")));
        listList.add(new ArrayList<>(Arrays.asList("ANU","JFK")));
        listList.add(new ArrayList<>(Arrays.asList("JFK","ANU")));
        listList.add(new ArrayList<>(Arrays.asList("ANU","EZE")));
        listList.add(new ArrayList<>(Arrays.asList("TIA","ANU")));
        listList.add(new ArrayList<>(Arrays.asList("AXA","TIA")));
        listList.add(new ArrayList<>(Arrays.asList("TIA","JFK")));
        listList.add(new ArrayList<>(Arrays.asList("ANU","TIA")));
        listList.add(new ArrayList<>(Arrays.asList("JFK","TIA")));
        List<String> res = findItinerary(listList);
        System.out.println(res);
    }
}
