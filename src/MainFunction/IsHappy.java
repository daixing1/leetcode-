package MainFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/4/20
 * Time: 10:33
 * Description: 编写一个算法来判断一个数 n 是不是快乐数。
 *              「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 *              然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果可以变为1，
 *              那么这个数就是快乐数。
 *              如果 n 是快乐数就返回 True ；不是，则返回 False 。
 */
public class IsHappy {
    List<Integer> list = new ArrayList<>();
    public boolean isHappy(int n) {
        if (list.contains(n)){
            return false;
        }
        list.add(n);
        int m = 0;
        while (n>9){
            m+=Math.pow((n%10),2);
            n = n/10;
        }
        m+=Math.pow(n,2);
        if (m==1){
            return true;
        }
        return isHappy(m);
    }

    public boolean isHappy1(int n) {
        if (n==1){
            return true;
        }
        if (n==0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int num = n;
        while (num!=1){
            List<Integer> allDigita = getAllDigita(num);
            num = 0;
            for (int m:allDigita){
                num+=Math.pow(m,2);
            }
            if (set.contains(num)){
                return false;
            }else {
                set.add(num);
            }
        }
        return true;
    }

    private List<Integer> getAllDigita(int n){
        List<Integer> list = new ArrayList<>();
        while (n>9){
            list.add(n%10);
            n/=10;
        }
        list.add(n);
        return list;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        boolean happy1 = isHappy.isHappy1(1);
        System.out.println(happy1);
    }
}
