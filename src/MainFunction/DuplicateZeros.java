package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/29
 * Time: 11:06
 * Description: 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *              注意：请不要在超过该数组长度的位置写入元素。
 *              要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        for (int i=0;i<arr.length;i++){
            if (arr[i]==0){
                for (int j=arr.length-1;j>i+1;j--){
                    arr[j] = arr[j-1];
                }
                if (i!=arr.length-1){
                    arr[++i]=0;
                }
            }
        }
    }
}
