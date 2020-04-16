package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/27
 * Time: 0:22
 * Description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *              请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *              你可以假设 nums1 和 nums2 不会同时为空。
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0;
        for (int i = (nums1.length-1)/2,j = (nums2.length-1)/2;i+j<(nums1.length+nums2.length)/2+1;){
            if ((nums1.length+nums2.length)%2==0){
                if (i+1+j+1==(nums1.length+nums2.length)/2-1){
                    if (nums1[i]<nums2[j]){
                        mid+=nums2[j];
                    }else {
                        mid+=nums2[i];
                    }
                }
                if (i+1+j+1==(nums1.length+nums2.length)/2){
                    if (nums1[i]<nums2[j]){
                        mid+=nums2[j];
                    }else {
                        mid+=nums2[i];
                    }
                }
            }else {
                if (i+1+j+1==(nums1.length+nums2.length)/2){

                }
            }
            if (nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        return 0.0;
    }
}
