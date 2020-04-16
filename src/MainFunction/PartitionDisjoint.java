package MainFunction;

/**
 * User: 兴希
 * Date: 2020/3/31
 * Time: 11:08
 * Description: 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 *              left 中的每个元素都小于或等于 right 中的每个元素。
 *              left 和 right 都是非空的。
 *              left 要尽可能小。
 *              在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。

 */
public class PartitionDisjoint {
    public static int partitionDisjoint(int[] A) {
        int left = 0;
        if (A.length==2&&A[0]<=A[1]){
            return 1;
        }
        for (int i=1;i<A.length;i++){
            int min = A[i];
            int max = 0;
            for (int start=0;start<i;start++){
                if (A[start]>max){
                    max = A[start];
                }
            }
            for (int end=A.length-1;end>i;end--){
                if (A[end]<min){
                    min = A[end];
                }
            }
            if (max<=min){
                left = i;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int i = partitionDisjoint(new int[]{26,51,40,58,42,76,30,48,79,91});
        System.out.println(i);
    }
}
