package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/30
 * Time: 21:26
 * Description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *              求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i=0;i<heights.length;i++){
            int tmp = 0;
            int min = heights[i];
            for (int j=i;j>=0;j--){
                min = Math.min(min,heights[j]);
                tmp = Math.max(tmp,min*(i-j+1));
            }
            max = Math.max(max,tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = largestRectangleArea(new int[]{2,1,5,6,2,3});
        System.out.println();
    }
}
