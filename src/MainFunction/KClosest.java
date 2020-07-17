package MainFunction;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: 兴希
 * Date: 2020/5/30
 * Time: 21:40
 * Description: 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *              （这里，平面上两点之间的距离是欧几里德距离。）
 *              你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        int[][] sotrArr = new int[points.length][3];
        int distance = 0;
        int index = 0;
        for (int[] arr:points){
            distance = (int)Math.pow(arr[0],2)+(int)Math.pow(arr[1],2);
            sotrArr[index++] = new int[]{arr[0],arr[1],distance};
        }
        Arrays.sort(sotrArr,(o1, o2) -> (o1[3]-o2[3]));
        for (int i=0;i<K;i++){
            res[i] = new int[]{sotrArr[i][0],sotrArr[i][1]};
        }
        return res;
    }
}
