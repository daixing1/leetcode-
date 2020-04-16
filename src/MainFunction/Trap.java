package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/4
 * Time: 9:25
 * Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {
    public int trap(int[] height) {
        if (height.length==0){
            return 0;
        }
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        while (left<right){
            if (height[left]<height[right]){
                if (leftMax>=height[left]){
                    ans+=leftMax-height[left];
                }else {
                    leftMax = height[left];
                }
                ++left;
            }else {
                if (rightMax>=height[right]){
                    ans+=rightMax-height[right];
                }else {
                    rightMax = height[right];
                }
                --right;
            }
        }
        return ans;
    }
}
