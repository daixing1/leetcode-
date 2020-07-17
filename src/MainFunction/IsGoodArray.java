package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/21
 * Time: 10:51
 * Description: 给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个
 *              任意整数，并求出他们的和。
 *              假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
 */
public class IsGoodArray {
    //如果有两个互质的数就是好数组
    public static boolean isGoodArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n:nums){
            min = Math.min(min,n);
        }
        if (min<2){
            return true;
        }
        for (int i=2;i<=min;i++){
            boolean flag = false;
            for (int n:nums){
                if (n%i!=0){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                return flag;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean goodArray = isGoodArray(new int[]{3, 6});
    }
}
