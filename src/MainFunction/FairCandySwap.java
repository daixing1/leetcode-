package MainFunction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/8/22
 * Time: 20:59
 * Description: 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 *              因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总
 *              量是他们拥有的糖果棒大小的总和。）
 *              返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的
 *              糖果棒的大小。
 *              如果有多个答案，你可以返回其中任何一个。保证答案存在。
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int sumB = 0;
        for (int n:B){
            sumB+=n;
            set.add(n);
        }
        int sumA = Arrays.stream(A).sum();
        int num = (sumA+sumB)/2;
        int diffA = num-sumA;
        for (int n:A){
            if (set.contains(diffA+n)){
                return new int[]{n,diffA+n};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        FairCandySwap fairCandySwap = new FairCandySwap();
        int[] ints = fairCandySwap.fairCandySwap(new int[]{1,2,5}, new int[]{2,4});
        System.out.println();
    }
}
