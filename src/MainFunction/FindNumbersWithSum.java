package MainFunction;

import java.util.ArrayList;

/**
 * User: 兴希
 * Date: 2020/3/5
 * Time: 1:20
 * Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *              如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 1;
        int minMul = Integer.MAX_VALUE;
        while(start<end&&end<array.length){
            if(array[start]+array[end]==sum){
                if(array[start]*array[end]<minMul){
                    result.clear();
                    result.add(array[start]);
                    result.add(array[end]);
                }
            }else if(array[start]+array[end]>sum){
                start++;
                end--;
            }else{
                end++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        findNumbersWithSum()
    }
}
