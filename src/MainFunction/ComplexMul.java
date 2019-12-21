package MainFunction;

/**
 * User: 兴希
 * Date: 2019/12/12
 * Time: 19:54
 * Description: 复数相乘
 */
public class ComplexMul {
    public String complexNumberMultiply(String a, String b) {
        int a1 = Integer.valueOf(a.substring(0,a.indexOf('+')));
        int a2 = Integer.valueOf(a.substring(a.indexOf('+')+1,a.indexOf('i')));
        int b1 = Integer.valueOf(b.substring(0,b.indexOf('+')));
        int b2 = Integer.valueOf(b.substring(b.indexOf('+')+1,b.indexOf('i')));
        int sum = a1*b1-a2*b2;
        int complex = a1*b2+a2*b1;
        String result = String.valueOf(sum) + '+' +String.valueOf(complex) +'i';
        return result;
    }
}
