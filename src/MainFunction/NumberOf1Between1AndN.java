package MainFunction;

/**
 * User: 兴希
 * Date: 2020/3/4
 * Time: 22:27
 * Description: 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包
 *              含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,
 *              并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {
    public static int numberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i=1;i<=n;i*=10){
            count+=n/(i*10)*i;
            int end = n%(i*10);
            if (end>=i&&end<2*i){
                count+=end-i+1;
            }else if (end>=i*2){
                count+=i;
            }else if (end<i){

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = numberOf1Between1AndN_Solution(1);
        System.out.println();
    }
}