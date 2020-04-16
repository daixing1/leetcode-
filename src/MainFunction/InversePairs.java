package MainFunction;

/**
 * User: 兴希
 * Date: 2020/3/5
 * Time: 0:14
 * Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组
 *              ,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    public int inversePairs(int [] array) {
        int count = 0;
        for (int i=0;i<array.length-1;i++){
            for (int j = i+1;j<array.length;j++){
                if (array[i]>array[j]){
                    count++;
                }
            }
        }
        return count%1000000007;
    }
}
