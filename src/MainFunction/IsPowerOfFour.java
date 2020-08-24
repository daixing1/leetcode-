package MainFunction;

/**
 * User: 兴希
 * Date: 2020/8/13
 * Time: 20:54
 * Description: 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num==1){
            return true;
        }
        if (num<1||num%4!=0){
            return false;
        }
        return isPowerOfFour(num/4);
    }
}
