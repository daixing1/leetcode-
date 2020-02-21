package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/21
 * Time: 15:08
 * Description: 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNums {
    public int sumNums(int n) {
        Integer result = 0;
        boolean b = (n>0)&& (result=n+sumNums(n-1))>0;
        return result;
    }
}
