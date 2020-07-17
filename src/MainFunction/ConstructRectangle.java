package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/16
 * Time: 9:55
 * Description: 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，
 *              你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 *                  1. 你设计的矩形页面必须等于给定的目标面积。
 *                  2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 *                  3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 *              你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 */
public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        for (int i = (int)Math.sqrt(area);i<=area;i++){
            if (area%i==0){
                if (i>area/i){
                    res[0] = i;
                    res[1] = area/i;
                }else {
                    res[1] = i;
                    res[0] = area/i;
                }
                break;
            }
        }
        return res;
    }
}
