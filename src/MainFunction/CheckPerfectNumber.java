package MainFunction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    public boolean checkPerfectNumber1(int num) {
        if (num==0||num==1){
            return false;
        }
        Set<Integer> set = getAllDigita(num);
        int n = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            n+=iterator.next();
        }
        return n==num*2;
    }

    private Set<Integer> getAllDigita(int num){
        Set<Integer> set = new HashSet<>();
        for (int i=1;i<=Math.sqrt(num);i++){
            if (num%i==0){
                set.add(i);
                set.add(num/i);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        CheckPerfectNumber checkPerfectNumber = new CheckPerfectNumber();
        boolean b = checkPerfectNumber.checkPerfectNumber1(28);
        System.out.println(b);
    }
}
