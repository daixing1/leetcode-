package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/8/10
 * Time: 15:19
 * Description: 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID
 *              进行标识。
 *              在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。
 *              对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 *              公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，
 *              然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 *              第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，
 *              他的所有直属下属都可以开始传播这一消息）。
 *              返回通知所有员工这一紧急消息所需要的 分钟数
 */
public class NumOfMinutes {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<n;i++){
            if (manager[i]==-1){
                continue;
            }
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i],list);
        }
        int sumTime = 0;
        sumTime+=informTime[headID];
        List<Integer> list = map.get(headID);
        while (list!=null&&list.size()>0){
            sumTime+=getMaxTime(list,informTime);
            List<Integer> inform = new ArrayList<>();
            for (int m:list){
                if (map.containsKey(m)){
                    inform.addAll(map.get(m));
                }
            }
            list = inform;
        }
        return sumTime;
    }

    private int getMaxTime(List<Integer> list, int[] time){
        return list.stream().mapToInt(n->time[n]).max().getAsInt();
    }

    public static void main(String[] args) {

        NumOfMinutes numOfMinutes = new NumOfMinutes();
//        int maxTime = numOfMinutes.getMaxTime(Arrays.asList(1, 2, 3), new int[]{1, 2, 3, 4, 5, 6});
//        System.out.println(maxTime);
        int i = numOfMinutes.numOfMinutes(11, 4,
                        new int[]{5,9,6,10,-1,8,9,1,9,3,4},
                new int[]{0,213,0,253,686,170,975,0,261,309,337});
        System.out.println(i);
    }
}
