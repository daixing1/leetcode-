package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/20
 * Time: 22:27
 * Description: 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 
 *              位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 *                  第 i 位的数字能被 i 整除
 *                  i 能被第 i 位上的数字整除
 *              现在给定一个整数 N，请问可以构造多少个优美的排列
 */
public class CountArrangement {
    public int countArrangement(int N) {
        int res = 0;
        for (int i=1;i<N;i++){
            res+=N/i - 1;
        }
        res++;
        return res;
    }
}
