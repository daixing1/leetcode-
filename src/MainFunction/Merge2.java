package MainFunction;

/**
 * User: 兴希
 * Date: 2019/12/27
 * Time: 17:18
 * Description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *              说明:
 *                  初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *                  你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
 */
public class Merge2 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int count = 0;
        for (int i=0;i<m+count;i++){
            while (j<n){
                if (nums1[i]>nums2[j]){
                    for (int k=m+count;k>i;k--){
                        nums1[k] = nums1[k-1];
                    }
                    nums1[i] = nums2[j];
                    count++;
                    j++;
                }
                break;
            }
        }
        if (j<n){
            for (int k=j;k<n;k++){
                nums1[m+count] = nums2[k];
                count++;
            }
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        System.out.println("ddd");
    }
}
