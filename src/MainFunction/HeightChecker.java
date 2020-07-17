package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/26
 * Time: 11:04
 * Description: 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *              请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 *              注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，
 *              而未被选中的学生应该保持不动。
 */
public class HeightChecker {
    public static int heightChecker(int[] heights) {
        if (heights.length<2){
            return 0;
        }
        List<Integer> h = new ArrayList<>();
        for (int i=0;i<heights.length;i++){
            int min = heights[i];
            int pos = 0;
            boolean flag = false;
            for (int j=heights.length-1;j>=i;j--){
                if (heights[j]<min){
                    min = heights[j];
                    pos = j;
                    flag = true;
                }
            }
            if (flag) {
                int tmp = heights[i];
                heights[i] = heights[pos];
                heights[pos] = tmp;
                if (!h.contains(i)) {
                    h.add(i);
                }
                if (!h.contains(pos)) {
                    h.add(pos);
                }
            }
        }
        return h.size();
    }

    public static int heightChecker1(int[] heights) {
        // 值的范围是1 <= heights[i] <= 100，因此需要1,2,3,...,99,100，共101个桶
        int[] arr = new int[101];
        // 遍历数组heights，计算每个桶中有多少个元素，也就是数组heights中有多少个1，多少个2，。。。，多少个100
        // 将这101个桶中的元素，一个一个桶地取出来，元素就是有序的
        for (int height : heights) {
            arr[height]++;
        }

        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            // arr[i]，i就是桶中存放的元素的值，arr[i]是元素的个数
            // arr[i]-- 就是每次取出一个，一直取到没有元素，成为空桶
            while (arr[i]-- > 0) {
                // 从桶中取出元素时，元素的排列顺序就是非递减的，然后与heights中的元素比较，如果不同，计算器就加1
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = heightChecker1(new int[]{2,1,2,1,1,2,2,1});
        System.out.println(i);
    }
}
