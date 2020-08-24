package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/8/9
 * Time: 22:27
 * Description: 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 */
public class NonNegativeAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countNN = 0;
        double res = 0;
        int total = 0;
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            list.add(n);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)<0){
                countNN++;
            }else {
                total+=list.get(i);
            }
        }
        res = Math.round((total*10/(list.size()-countNN))/10.0);
        System.out.println(countNN);
        System.out.println(res);
    }
}
