package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/10
 * Time: 10:08
 * Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 *              输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
public class MinArray {
    public static int minArray(int[] numbers) {
        if (numbers.length==1){
            return numbers[0];
        }
        if (numbers.length==2){
            return Math.min(numbers[0],numbers[1]);
        }
        int left = 0;
        int right = numbers.length-1;
        int mid = (left+right)/2;
        while (left<right){
            mid = (left+right)/2;

            if (numbers[mid]>numbers[right]){
                //left-mid 递增,最小值在mid-right
                if (mid<numbers.length-1&&numbers[mid]>numbers[mid+1]){
                    return numbers[mid+1];
                }
                left = mid+1;

            }else if (numbers[mid]==numbers[right]&&numbers[mid]==numbers[left]){

            }
            //mid-right 递增 最小值在left-mid
            else {
                if (mid>0&&numbers[mid]<numbers[mid-1]){
                    return numbers[mid];
                }
                right = mid-1;
            }
        }
        return numbers[mid];
    }

    public static void main(String[] args) {
        int i = minArray(new int[]{1,10,10,10,10});
        System.out.println(i);
    }
}
