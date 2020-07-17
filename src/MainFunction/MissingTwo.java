package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/14
 * Time: 10:14
 * Description: 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1)
 *              的空间找到它们吗？
 *              以任意顺序返回这两个数字均可。
 */
public class MissingTwo {
    public int[] missingTwo(int[] nums) {
        int[] res = new int[2];
        StringBuilder sb = new StringBuilder("0".repeat(nums.length+2));
        for (int n:nums){
            sb.replace(n-1,n,"1");
        }
        int index = 0;
        for (int i=0;i<sb.length();i++){
            if (sb.charAt(i)=='0'){
                res[index++] = i+1;
            }
        }
        return res;
    }
}
