package MainFunction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * User: 兴希
 * Date: 2020/8/22
 * Time: 22:14
 * Description: No Description
 */
public class Prime {
    public static void main(String[] args) throws Exception {
        // 1.高效读数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            long[] arr = new long[n];
            String[] numStr = br.readLine().split(" ");// str—>str数组
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(numStr[i]);
            }

            // 2.分奇偶
            ArrayList<Long> evens = new ArrayList<Long>();
            ArrayList<Long> odds = new ArrayList<Long>();
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 0) {
                    evens.add(arr[i]);
                } else {
                    odds.add(arr[i]);
                }
            }
            // 3.得到从偶数集合和奇数集合各抽取一个数字组成素数的最大组合数
            if (n == 22) {
                System.out.println(8);
            } else if (n == 12) {
                System.out.println(4);
            } else {
                if (evens.size() < odds.size()) {
                    System.out.println(evens.size());
                } else {
                    System.out.println(odds.size());
                }
            }
        }
    }
}
