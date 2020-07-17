package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/6/13
 * Time: 14:55
 * Description: 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 *              至少有一个空座位，且至少有一人坐在座位上。
 *              亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *              返回他到离他最近的人的最大距离。
 */
public class MaxDistToClosest {
    public static int maxDistToClosest(int[] seats) {
        int pos = -1;
        int[] left = new int[seats.length];
        int[] right = new int[seats.length];
        for (int i=0;i<seats.length;i++){
            if (seats[i]==0){
                if (pos==-1){
                    left[i] = Integer.MAX_VALUE;
                }else {
                    left[i] = i-pos;
                }
            }else {
                pos = i;
            }
        }
        pos = -1;
        for (int i=seats.length-1;i>=0;i--){
            if (seats[i]==0){
                if (pos==-1){
                    right[i] = Integer.MAX_VALUE;
                }else {
                    right[i] = pos-i;
                }
            }else {
                pos = i;
            }
        }

        for (int i=0; i<seats.length;i++){
            left[i] = Math.min(left[i],right[i]);
        }
        return Arrays.stream(left).boxed().max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        int i = maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1});
        System.out.println(i);
    }
}
