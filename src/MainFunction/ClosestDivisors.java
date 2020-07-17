package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/14
 * Time: 10:42
 * Description: 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 *              两数乘积等于  num + 1 或 num + 2
 *              以绝对差进行度量，两数大小最接近
 *              你可以按任意顺序返回这两个整数
 */
public class ClosestDivisors {
    public static int[] closestDivisors(int num) {
        int[] num1 = getMinDiffFactor(num + 1);
        int[] num2 = getMinDiffFactor(num + 2);
        return num1[1]-num1[0]>num2[1]-num2[0]?num2:num1;
    }

    public static int[] getMinDiffFactor(int num){
        int min = num;
        int[] res = new int[2];
        for (int i=1;i<=Math.sqrt(num);i++){
            if (num%i==0){
                if (Math.abs(num/i-i)<min){
                    min = Math.abs(num/i-i);
                    res[0] = i;
                    res[1] = num/i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = closestDivisors(8);
        System.out.println(ints);
    }
}
