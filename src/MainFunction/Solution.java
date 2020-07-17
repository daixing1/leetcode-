package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/22
 * Time: 7:59
 * Description: 给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
 *              说明:
 *                  输入值和输出值都将是浮点数。
 *                  圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
 *                  圆周上的点也认为是在圆中。
 *                  randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组
 */
public class Solution {
    private double radius;
    private double x_center;
    private double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double x = Math.random();
        double y = Math.random();
        x = x*radius+x_center;
        y = y*radius+y_center;
        return new double[]{x,y};
    }
}
