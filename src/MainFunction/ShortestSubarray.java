package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/14
 * Time: 11:06
 * Description: 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *              如果没有和至少为 K 的非空子数组，返回 -1 。
 */
public class ShortestSubarray {
    public static int shortestSubarray(int[] A, int K) {
        if (A.length==1){
            return A[0]>=K?1:-1;
        }
        int[] pre = new int[A.length+1];
        for (int i=0;i<A.length;i++){
            pre[i+1] = pre[i]+A[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<pre.length-1;i++){
            for (int j=i+1;j<pre.length;j++){
                if (pre[j]-pre[i]>=K){
                    min = Math.min(min,j-i);
                    break;
                }
            }
        }
        if (min>A.length){
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        int i = shortestSubarray(new int[]{2, -1, 2}, 3);
        System.out.println(i);
    }
}
