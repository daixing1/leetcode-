package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/29
 * Time: 8:03
 * Description: 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *              你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 *              你从其中的一个加油站出发，开始时油箱为空。
 *              如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1
 */
public class CanCompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        boolean flag = true;
        for (int i=0;i<gas.length;i++){
            int count = 0;
            sum = 0;
            flag = true;
            while (count<gas.length){
                sum+=gas[(i+count)%gas.length];
                sum-=cost[(i+count)%gas.length];
                count++;
                if (sum<0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(i);
    }
}
