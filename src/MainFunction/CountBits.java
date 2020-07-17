package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 11:12
 * Description: 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的
 *              1 的数目并将它们作为数组返回。
 *              进阶:
 *                  给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内
 *                  用一趟扫描做到吗？
 *                  要求算法的空间复杂度为O(n)。
 *                  你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数
 *                  （如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i=0;i<=num;i++){
            res[i] = count1(i);
        }
        return res;
    }

    private int count1(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int m = n&1;
        n = n>>1;
        if (m==1){
            return 1+count1(n);
        }else {
            return count1(n);
        }
    }


}
