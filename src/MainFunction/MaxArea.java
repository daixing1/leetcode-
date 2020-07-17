package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/3
 * Time: 12:21
 * Description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 *              垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的
 *              容器可以容纳最多的水。
 *              说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int tmp = 0;
        for (int i=0;i<height.length-1;i++){
            if (height[i]<=left){
                continue;
            }else {
                left = height[i];
            }
            for (int j=height.length-1;j>=0;j--){
                if (height[j]<left){
                    max = Math.max(max,height[j]*(j-i));
                }else {
                    max = Math.max(max,height[i]*(j-i));
                    break;
                }
            }
        }
        return max;
    }
}
