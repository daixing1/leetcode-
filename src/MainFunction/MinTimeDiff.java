package MainFunction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2019/12/12
 * Time: 20:25
 * Description: 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 */
public class MinTimeDiff {

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("12:12");
        timePoints.add("12:13");
//        timePoints.add("00:35");
        System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        Integer min = 24*60;
        Integer max = 24*60;
        List<Integer> minutes = new ArrayList<>();
        for (int j=0;j<timePoints.size();j++){
            Integer jhours = Integer.valueOf(timePoints.get(j).substring(0,timePoints.get(j).indexOf(':')));
            Integer jminutes = Integer.valueOf(timePoints.get(j).substring(timePoints.get(j).indexOf(':')+1)) + jhours*60;
            minutes.add(jminutes);
        }
        List<Integer> collect = minutes.stream().sorted().collect(Collectors.toList());
        Integer sub = collect.get(collect.size()-1)-collect.get(0);
        min = sub > max - sub?max - sub:sub;
        for (int i = 0;i<collect.size()-1;i++){
            Integer diff = Math.abs(collect.get(i) - collect.get(i + 1));
            Integer diff2 = max - Math.abs(collect.get(i) - collect.get(i + 1));
            diff = diff2>diff?diff:diff2;
            min = min<diff?min:diff;
        }
        return min;
    }
}
