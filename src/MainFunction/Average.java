package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/7/21
 * Time: 20:16
 * Description: 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 *              请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 */
public class Average {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double i = Double.valueOf(Arrays.stream(salary).sum() - salary[0] - salary[salary.length - 1]) / (salary.length - 2);
        return i;
    }

    public static void main(String[] args) {
        Average average = new Average();
        double average1 = average.average(new int[]{48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000, 77000, 33000, 28000, 4000, 54000, 67000, 6000, 1000, 11000});
        System.out.println(average1);
    }
}
