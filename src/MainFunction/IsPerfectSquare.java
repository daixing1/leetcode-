package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/1
 * Time: 14:57
 * Description: 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *              说明：不要使用任何内置的库函数，如  sqrt
 */
public class IsPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        int low=0;
        int high = num/2;
        int mid = 0;
        if (num<2){
            return true;
        }
        while (low<=high){
            mid = (high+low)/2;
            if ((long)mid*mid<num){
                low = mid+1;
            }else if ((long)mid*mid>num){
                high = mid-1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean perfectSquare = isPerfectSquare(808201);
        System.out.println(perfectSquare);
    }
}
