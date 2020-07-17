package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/9
 * Time: 8:10
 * Description: 实现 int sqrt(int x) 函数。
 *              计算并返回 x 的平方根，其中 x 是非负整数。
 *              由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x<2){
            return x;
        }
        int mid = x/2;
        int left = 0;
        int right = x;
        while (left<right){
            if (mid*mid<x){
                left = mid+1;
                mid=(right+mid)/2;

            }else if (mid*mid>x){
                right = mid-1;
                mid=(left+mid)/2;
            }else {
                return mid;
            }
        }
        return mid;
    }
}
