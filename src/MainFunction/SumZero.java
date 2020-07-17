package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/26
 * Time: 8:03
 * Description: 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0
 */
public class SumZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i=0;i<n/2;i++){
            res[i*2] = i+1;
            res[i*2+1] = -(i+1);
        }
        if (n%2!=0){
            res[n-1] = 0;
        }
        return res;
    }
}
