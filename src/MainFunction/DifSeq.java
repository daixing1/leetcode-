package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/8/23
 * Time: 23:11
 * Description: 题目描述
 *                  有一天你得到了一个长度为 n 的序列，序列中的元素分别是 1,2,3,...,n。接下来你想对这个序
 *                  列进行一些操作。每一次操作你会选择一个数然后将它从序列中原来的位置取出并放在序列 的最前面。
 *                  你想知道经过一系列操作后这个序列长什么样。
 *              输入描述:
 *                  第一行包含两个整数𝑛, 𝑚，分别表示序列的长度和操作的个数。1 ≤ 𝑛, 𝑚 ≤ 105
 *                  接下来𝑚行每行包含一个整数𝑘𝑖，表示你要把𝑘𝑖放到序列的最前面。1 ≤ 𝑘𝑖 ≤ 𝑛
 *              输出描述:
 *                  从前往后输出序列中的每个元素，每个元素占一行
 */
public class DifSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>(n,0.75f,true);
            for (int i = 0; i < m; i++) {
                int num = scanner.nextInt();
                map.put(num,num);
            }
            for (int d:map.keySet()) {
                System.out.println(d);
            }
            for (int i = 1; i <= n; i++) {
                if (!map.containsKey(i)){
                    System.out.println(i);
                }
            }
        }
    }
}
