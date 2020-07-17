package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/20
 * Time: 22:36
 * Description: 给你一个以行程长度编码压缩的整数列表 nums 。
 *              考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] 
 *              （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，
 *              你需要从左到右连接所有子列表以生成解压后的列表。
 *              请你返回解压后的列表
 */
public class DecompressRLElist {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int m = 0;
        int n = 0;
        for (int i=1;i<nums.length;i++){
            if (i%2==1){
                m = nums[i-1];
                n = nums[i];
                for (int j=0;j<m;j++){
                    list.add(n);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
