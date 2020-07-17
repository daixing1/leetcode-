package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/8
 * Time: 20:59
 * Description: 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *              现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *              给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 */
public class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length==1){
            return 1;
        }
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else {
                return o1[0]-o2[0];
            }
        });
        int count = 1;
        int[] tmp = pairs[0];
        for (int i=1;i<pairs.length;i++){
            int[] pair = pairs[i];
            if (tmp[1]>pair[1]){
                tmp = pair;
            }else if (tmp[1]<pair[0]){
                count++;
                tmp = pair;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        FindLongestChain findLongestChain = new FindLongestChain();
        int count = findLongestChain.findLongestChain(new int[][]{{1, 2}, {2, 4}, {2, 3}});
        System.out.println(count);
    }
}
