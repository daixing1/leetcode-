package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/27
 * Time: 8:45
 * Description: 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目
 */
public class SubarraysDivByK {
    public static int subarraysDivByK(int[] A, int K) {
        int res = 0;
        int[] sum = new int[A.length];
        sum[0] = A[0];
        int[] count = new int[K];
        if (sum[0]%K<0){
            count[sum[0]%K+K]++;
        }else {
            count[sum[0]%K]++;
        }
        for (int i=1;i<A.length;i++){
            sum[i] = sum[i-1]+A[i];
            if (sum[i]%K<0){
                count[sum[i]%K+K]++;
            }else {
                count[sum[i]%K]++;
            }
        }
        for (int i=1;i<count.length;i++){
            res+=(count[i]-1)*count[i]/2;
        }
        res+=(count[0]+1)*count[0]/2;
        return res;
    }

    public static void main(String[] args) {
        int i = subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println(i);
    }
}
