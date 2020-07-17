package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/6/12
 * Time: 10:04
 * Description: 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，
 *              每个餐厅的名字用字符串表示。
 *              你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，
 *              则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 */
public class FindRestaurant {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i=0;i<list1.length;i++){
            map1.put(list1[i],i);
        }
        for (int i=0;i<list2.length;i++){
            map2.put(list2[i],i);
        }
        Arrays.sort(list1);
        Arrays.sort(list2);
        int i=0,j=0;
        int min = Integer.MAX_VALUE;
        List<String> stringList = new ArrayList<>();
        while (i<list1.length&&j<list2.length){
            while (i<list1.length&&j<list2.length&&list1[i].compareTo(list2[j])>0){
                j++;
            }
            if (i<list1.length&&j<list2.length&&list1[i].compareTo(list2[j])==0){
                if (map1.get(list1[i])+map2.get(list2[j])<min){
                    min = map1.get(list1[i])+map2.get(list2[j]);
                    stringList.clear();
                    stringList.add(list1[i]);
                }else if (map1.get(list1[i])+map2.get(list2[j])==min){
                    stringList.add(list1[i]);
                }
                i++;
                j++;
            }
            while (i<list1.length&&j<list2.length&&list1[i].compareTo(list2[j])<0){
                i++;
            }
        }
        String[] res = new String[stringList.size()];
        return stringList.toArray(res);
    }

    public static void main(String[] args) {
        String[] restaurant = findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Burger King","Tapioca Express","Shogun"});
        System.out.println(restaurant);
    }
}
