package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/6/15
 * Time: 9:35
 * Description: 给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。
 *              假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是
 *              进行三角剖分后所有 N-2 个三角形的值之和。
 *              返回多边形进行三角剖分后可以得到的最低分。
 */
public class MinScoreTriangulation {
    public int minScoreTriangulation(int[] A) {
        Arrays.sort(A);
        int res = A[0]*A[1];
        int sum = 0;
        for (int i=2;i<A.length;i++){
            sum+=res*A[i];
        }
        return sum;
    }
}
