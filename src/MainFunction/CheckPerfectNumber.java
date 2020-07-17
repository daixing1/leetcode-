package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/7
 * Time: 11:58
 * Description: 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *              给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 */
public class CheckPerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num==1){
            return false;
        }
        int sum = 0;
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i==0){
                if (num==i*i){
                    sum+=i;
                }else {
                    sum+=i+num/i;
                }
            }
        }
        return sum+1==num;
    }
}
