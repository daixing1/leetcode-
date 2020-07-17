package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/16
 * Time: 13:12
 * Description: 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *              返回重复了 N 次的那个元素。
 */
public class RepeatedNTimes {
    public int repeatedNTimes(int[] A) {
        int res = A[0];
        int count = 1;
        for (int i=1;i<A.length;i++){
            if (A[i]==res){
                count++;
            }else {
                count--;
            }
            if (count==0){
                if (i==A.length-1){
                    return res;
                }else {
                    res = A[i];
                    count = 1;
                }
            }
        }
        return res;
    }
}
