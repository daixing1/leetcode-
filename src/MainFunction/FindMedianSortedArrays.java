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
        int count = (nums1.length+nums2.length)/2;
        int i = nums1.length/2;
        int j = nums2.length/2;
//        while (true){
//            if (i+j<count){
//                if (nums1[i]<nums2[j]){
//                    i = (i+nums1.length)/2;
//                }else {
//                    j = (j+nums2.length)/2;
//                }
//            }else if (i+j>count){
//                if (nums1[i]<nums2[j]){
//                    j = (i+nums1.length)/2;
//                }else {
//                    j = (j+nums2.length)/2;
//                }
//            }
//        }
        return 0.0;
    }
}
