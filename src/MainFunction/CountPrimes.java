package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/20
 * Time: 10:52
 * Description: 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        int count=0;
        boolean[] nums = new boolean[n];
        for (int i=2;i<n;i++){
            for (int j=i*i;j<n;j+=i){
                if (nums[j]){
                    continue;
                }
                count++;
                nums[j]=true;
            }

        }
        return n-count-2;
    }


    public static void main(String[] args) {
        int i = countPrimes(10);
    }
}
